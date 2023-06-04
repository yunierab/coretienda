package edu.tienda.core.controllers;

import edu.tienda.core.domain.Cliente;
import edu.tienda.core.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteRestController
{
    private List<Cliente>clientes = new ArrayList<>(Arrays.asList
            (new Cliente("yunier","123","Yunier"),
                    new Cliente("yunia","123","Yunia"),
                    new Cliente("ramona","123","Ramona")));

    //Obtenemos el listado de clientes
    @GetMapping
    public ResponseEntity<?> getClientes()
    {
        return ResponseEntity.ok(clientes);
    }

    //Obtenemos un cliente dado su username
    @GetMapping("/{username}")
    public ResponseEntity<?> getCliente(@PathVariable String username)
    {
        for (Cliente c: clientes)
        {
            if(c.getUsername().equalsIgnoreCase(username))
            {
                return ResponseEntity.ok(c);
            }
        }
        throw  new ResourceNotFoundException("Cliente no encontrado");
    }

    //Adicionamos un nuevo cliente
    @PostMapping
    public ResponseEntity<?> altaCliente(@RequestBody Cliente cliente)
    {
        clientes.add(cliente);

        //Obteniendo URL de servicio
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{username}")
                .buildAndExpand(cliente.getUsername())
                .toUri();

        //Se retorna el path donde se puede ver el recurso creado mas el propio cliente creado
        return ResponseEntity.created(location).body(cliente);
    }

    //Modificamos un cliente
    @PutMapping
    public ResponseEntity<?>  modificacionCliente(@RequestBody Cliente cliente)
    {
        //Busco el cliente por su username
        Cliente clienteEncontrado = clientes.stream().filter(cli -> cli.getUsername().equalsIgnoreCase(cliente.getUsername())).findFirst().orElseThrow();

        //Actualizo los datos del cliente encontrado

        clienteEncontrado.setNombre(cliente.getNombre());
        clienteEncontrado.setPasword(cliente.getPasword());

        return ResponseEntity.ok(clienteEncontrado);
    }

    //Eliminamos un cliente
    @DeleteMapping("/{username}")
    public ResponseEntity eliminarCliente(@PathVariable String username)
    {
        //Busco el cliente por su username
        Cliente clienteEncontrado = clientes.stream().filter(cli -> cli.getUsername().equalsIgnoreCase(username)).findFirst().orElseThrow();

        //Elimino el cliente encontrado
        clientes.remove(clienteEncontrado);

        return ResponseEntity.noContent().build();
    }
}
