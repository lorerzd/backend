package org.generation.naomdb.controller;


import org.generation.naomdb.model.Usuario;
import org.generation.naomdb.repository.UsuarioRepository;
import org.generation.naomdb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    @Autowired
    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @GetMapping
    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }
}
