package edu.tienda.core.services;

import java.io.IOException;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.tienda.core.domain.Producto;


@Service("JSON")
//@Primary  //para darle preferencia a este bean(por encima del otro servicio que implementa la misma interfaz) cuando se inyecte en el controlador
public class ProductoServiceFromJsonImpl implements IProductoService {
	
	public List<Producto> getProductos() {
		 List<Producto> productos;
		 
		 try {
			productos = new ObjectMapper().readValue(this.getClass().getResourceAsStream("/productos.json"), new TypeReference<List<Producto>>() {});
			return productos;
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

}
