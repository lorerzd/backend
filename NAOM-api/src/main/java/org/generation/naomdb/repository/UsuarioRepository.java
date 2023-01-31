package org.generation.naomdb.repository;

import org.generation.naomdb.model.Usuario; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    Optional<Usuario> findByCorreo(String correo);

    @Transactional
    Optional<Usuario> deleteByCorreo(String correo);

}
