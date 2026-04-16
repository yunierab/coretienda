package edu.tienda.core.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.tienda.core.domain.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {
	
	private List<Producto> productos = new ArrayList<>(Arrays.asList(new Producto(1, "Laptop", 500.0, 150),
			new Producto(2, "TV", 250.0, 100), new Producto(3,"Celular", 100.0, 15)));
	
	
	public List<Producto> getProductos() {
		return productos;
	}

}
