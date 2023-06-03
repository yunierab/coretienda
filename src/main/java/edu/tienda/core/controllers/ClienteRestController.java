package edu.tienda.core.controllers;

import edu.tienda.core.domain.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteRestController
{
    private List<Cliente>clientes = new ArrayList<>(Arrays.asList
            (new Cliente("yunier","123","Yunier"),
                    new Cliente("yunia","123","Yunia"),
                    new Cliente("ramona","123","Ramona")));

    //Obtenemos el listado de clientes
    @GetMapping("/clientes")
    public List<Cliente> getClientes()
    {
        return clientes;
    }

    //Obtenemos un cliente dado su username
    @GetMapping("/clientes/{username}")
    public Cliente getCliente(@PathVariable String username)
    {
        for (Cliente c: clientes)
        {
            if(c.getUsername().equalsIgnoreCase(username))
            {
                return c;
            }
        }
        return null;
    }

    //Adicionamos un nuevo cliente
    @PostMapping("/clientes")
    public Cliente altaCliente(@RequestBody Cliente cliente)
    {
        clientes.add(cliente);
        return cliente;
    }

    //Modificamos un cliente
    @PutMapping("/clientes")
    public Cliente modificacionCliente(@RequestBody Cliente cliente)
    {
        //Busco el cliente por su username
        Cliente clienteEncontrado = getCliente(cliente.getUsername());

        //Actualizo los datos del cliente encontrado
        if(clienteEncontrado!=null)
        {
            clienteEncontrado.setNombre(cliente.getNombre());
            clienteEncontrado.setPasword(cliente.getPasword());
        }
        return clienteEncontrado;
    }

    //Eliminamos un cliente
    @DeleteMapping("/clientes/{username}")
    public void eliminarCliente(@PathVariable String username)
    {
        //Busco el cliente por su username
        Cliente clienteEncontrado = getCliente(username);

        //Elimino el cliente encontrado
        if(clienteEncontrado!=null)
        {
            clientes.remove(clienteEncontrado);
        }
    }
}
