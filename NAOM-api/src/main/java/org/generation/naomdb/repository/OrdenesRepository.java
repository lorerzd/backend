package org.generation.naomdb.repository;

import org.aspectj.weaver.ast.Or;
import org.generation.naomdb.model.Ordenes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdenesRepository extends JpaRepository<Ordenes, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM Ordenes WHERE usuario_id = ?1")
    Optional<List<Ordenes>> findOrdenesByUser(Long id);

}
