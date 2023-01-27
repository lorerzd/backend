package org.generation.naomdb.repository;

import org.generation.naomdb.model.Ordenes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenesRepository extends JpaRepository<Ordenes, Long> {

}
