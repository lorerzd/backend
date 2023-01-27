package org.generation.naomdb.service;

import org.generation.naomdb.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
