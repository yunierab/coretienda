package edu.tienda.core.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.tienda.core.configurations.ConfigurationParameters;
import edu.tienda.core.domain.Cliente;
import edu.tienda.core.domain.Producto;
import edu.tienda.core.services.IProductoService;


@RestController
@RequestMapping("/productos")
public class ProductoRestController {

	@Autowired
	@Qualifier("API_EXTERNA")  //inyectamos el servicio por su alias
	private IProductoService productoServices;
	
	@Autowired
	private ConfigurationParameters config;
	
	@GetMapping
	public ResponseEntity<?> getProductos() {
		//System.out.println(config.toString());
		List<Producto> productos = productoServices.getProductos();
		return ResponseEntity.ok(productos);
	}
	
	@GetMapping("/fake-productos")
	public ResponseEntity<?> fakeProductosAPI() {
		
		List<Producto> productos = new ArrayList<>(Arrays.asList(new Producto(1, "Camiseta Real Madrid", 200.0, 5),
				                                                 new Producto(2, "Camiseta Juventus", 150.0, 10), 
				                                                 new Producto(3, "Camiseta Barcelona", 140.0, 15)));
		
		return ResponseEntity.ok(productos);
	}

}
