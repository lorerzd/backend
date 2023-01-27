package org.generation.naomdb.controller;

import org.generation.naomdb.model.Categorias;
import org.generation.naomdb.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/categorias")
public class CategoriasController {

    @Autowired
    private final CategoriasRepository categoriasRepository;

    public CategoriasController(CategoriasRepository categoriasRepository) {
        this.categoriasRepository = categoriasRepository;
    }

    @GetMapping
    public List<Categorias> findAll(){
        return  categoriasRepository.findAll();
    }
}
