package org.generation.naomdb.service;

import org.generation.naomdb.exception.OrdenNotFound;
import org.generation.naomdb.model.Estado;
import org.generation.naomdb.model.Ordenes;
import org.generation.naomdb.model.Producto;
import org.generation.naomdb.repository.OrdenesRepository;
import org.generation.naomdb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenesService {

    private final OrdenesRepository ordenesRepository;

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public OrdenesService(OrdenesRepository ordenesRepository, UsuarioRepository usuarioRepository) {
        this.ordenesRepository = ordenesRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Ordenes deleteOrden(String correo, Long id) throws OrdenNotFound, ServletException {
        Optional<Ordenes> ordenesOpt = ordenesRepository.findById(id);
        if (ordenesOpt.isPresent()) {
            Ordenes ordenes = ordenesOpt.get();
            if(ordenes.getUsuario().getCorreo() == correo){
                ordenesRepository.deleteById(id);
                return ordenes;
            }
            throw new ServletException("You dont own this order");
        }
        throw new OrdenNotFound("Orden con el id " + id + " no se encuentra");
    }

    public Ordenes updateOrden(String correo,
                               Long id,
                               Integer cantidad,
                               BigDecimal totalOrden,
                               List<Producto> productos,
                               Estado estado) throws OrdenNotFound, ServletException {
        Optional<Ordenes> ordenes = ordenesRepository.findById(id);
        if (ordenes.isPresent()) {
            Ordenes ord = ordenes.get();
            if(ord.getUsuario().getCorreo().equals(correo)){
                if (cantidad != null) ord.setCantidad(cantidad);
                if (totalOrden != null) ord.setTotalOrden(totalOrden);
                if (productos != null) ord.setProductos(productos);
                if (estado != null) ord.setEstado(estado);
                ordenesRepository.save(ord);
                return ord;
            }else {
                throw new ServletException("You dont own this order");
            }
        }
        throw new OrdenNotFound("Orden con el id " + id + " no se encuentra");
    }
}
