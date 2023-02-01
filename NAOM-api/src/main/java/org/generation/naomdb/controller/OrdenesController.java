package org.generation.naomdb.controller;

import org.generation.naomdb.helper.TokenHelper;
import org.generation.naomdb.exception.OrdenNotFound;
import org.generation.naomdb.model.Estado;
import org.generation.naomdb.model.Ordenes;
import org.generation.naomdb.model.Producto;
import org.generation.naomdb.service.OrdenesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/orden")
@CrossOrigin(origins = "*")
public class OrdenesController {

    //FALTA TOKEN PARA IDENTIFICAR AL USUARIO Y MODIFICAR SUS ORDENES

    private final OrdenesService ordenesService;

    @Autowired
    public OrdenesController(OrdenesService ordenesService) {
        this.ordenesService = ordenesService;
    }



    @DeleteMapping(path = "{pathId}")
    public Ordenes deleteOrden(HttpServletRequest request,
                               @PathVariable("pathId") Long id) throws OrdenNotFound, ServletException {
        String token = TokenHelper.getTokenFromHeader(request);
        String subject = TokenHelper.getEmailFromToken(token);
        return ordenesService.deleteOrden(subject,id);
    }

    @PutMapping(path = "{pathId}")
    public Ordenes updateOrden(HttpServletRequest request,
                               @PathVariable("pathId") Long id,
                               @RequestParam(required = false) Integer cantidad,
                               @RequestParam(required = false) BigDecimal totalOrden,
                               @RequestParam(required = false) Estado estado,
                               @RequestBody(required = false) List<Producto> productos) throws OrdenNotFound, ServletException {
        String token = TokenHelper.getTokenFromHeader(request);
        String correo = TokenHelper.getEmailFromToken(token);
        System.out.println(cantidad);
        return ordenesService.updateOrden(correo ,id, cantidad, totalOrden, productos, estado);
    }

}
