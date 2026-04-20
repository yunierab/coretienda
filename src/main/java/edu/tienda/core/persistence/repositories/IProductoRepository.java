package edu.tienda.core.persistence.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.tienda.core.persistence.entities.ProductoEntity;

@Repository
public interface IProductoRepository extends JpaRepository<ProductoEntity, Integer> {
	
	//JPA Wildcards
	List<ProductoEntity> findByPrecioLessThan(Double precio);
	List<ProductoEntity> findByNombreLike(String nombre);
	List<ProductoEntity> findByPrecioGreaterThanAndStockLessThan(Double precio, Integer stock); 

}
