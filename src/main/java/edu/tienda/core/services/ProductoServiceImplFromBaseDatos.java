package edu.tienda.core.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tienda.core.domain.Producto;
import edu.tienda.core.persistence.entities.ProductoEntity;
import edu.tienda.core.persistence.repositories.IProductoRepository;

@Service("BaseDatos") //Le damos un alias al servicio
public class ProductoServiceImplFromBaseDatos implements IProductoService {
	
	@Autowired
	private IProductoRepository productoRepository;

	
	public List<Producto> getProductos() {
		List<ProductoEntity> prod = productoRepository.findAll();
		List<Producto> productos = new ArrayList<>();
		
		for(ProductoEntity p : prod) {
			Producto producto = new Producto(p.getId(), p.getNombre(), p.getPrecio(), p.getStock());
			productos.add(producto);
		}
		return productos;
	}

}
