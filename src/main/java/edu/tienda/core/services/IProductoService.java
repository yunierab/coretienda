package edu.tienda.core.services;

import java.util.List;

import edu.tienda.core.domain.Producto;

public interface IProductoService {
	
	public List<Producto> getProductos();
	public void saveProducto(Producto producto);
	

}
