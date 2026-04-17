package edu.tienda.core.persistence.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.tienda.core.persistence.entities.ProductoEntity;

@Repository
public interface IProductoRepository extends JpaRepository<ProductoEntity, Integer> {

}
