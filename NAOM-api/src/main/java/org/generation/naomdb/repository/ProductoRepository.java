package org.generation.naomdb.repository;

import org.generation.naomdb.model.Ordenes;
import org.generation.naomdb.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{

    @Query(nativeQuery = true, value = "SELECT * FROM productos WHERE categorias_id = ?1")
    Optional<List<Producto>> findTipoProducto(Long id);
}
