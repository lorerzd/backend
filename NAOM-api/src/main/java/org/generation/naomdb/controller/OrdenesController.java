package org.generation.naomdb.controller;

import org.generation.naomdb.exception.OrdenNotFound;
import org.generation.naomdb.model.Ordenes;
import org.generation.naomdb.model.Producto;
import org.generation.naomdb.service.OrdenesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/orden")
public class OrdenesController {

    //FALTA TOKEN PARA IDENTIFICAR AL USUARIO Y MODIFICAR SUS ORDENES

    private final OrdenesService ordenesService;

    @Autowired
    public OrdenesController(OrdenesService ordenesService) {
        this.ordenesService = ordenesService;
    }

    @GetMapping
    public List<Ordenes> getOrdenesFromUsuario() throws OrdenNotFound {
        return ordenesService.getOrdenesFromUsuario(2L);
    }

    @DeleteMapping(path = "{pathId}")
    public Ordenes deleteOrden(@PathVariable("pathId") Long id) throws OrdenNotFound {
        return ordenesService.deleteOrden(id);
    }

    @PutMapping(path = "{pathId}")
    public Ordenes updateOrden(@PathVariable("pathId") Long id,
                               @RequestParam(required = false) int cantidad,
                               @RequestParam(required = false) BigDecimal totalOrden,
                               @RequestBody(required = false) List<Producto> productos) throws OrdenNotFound {
        return ordenesService.updateOrden(id, cantidad, totalOrden, productos);
    }

}
