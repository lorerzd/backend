package org.generation.naomdb.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.generation.naomdb.exception.UserNotFound;
import org.generation.naomdb.model.Ordenes;
import org.generation.naomdb.model.Usuario;
import org.generation.naomdb.repository.OrdenesRepository;
import org.generation.naomdb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;

    private final OrdenesRepository ordenesRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, OrdenesRepository ordenesRepository) {
        this.usuarioRepository = usuarioRepository;
        this.ordenesRepository = ordenesRepository;
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    } // getAllUsuarios

    public Usuario getUsuario(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("El Usuario con el id " + id + " no existe.")
        );
    }// getUsuario

    public Usuario addUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    } // addUsuario

    public Usuario deleteUsuario(Long id) {
        Usuario tmp = null;
        if (usuarioRepository.existsById(id)) {
            tmp = usuarioRepository.findById(id).get();
            usuarioRepository.deleteById(id);
        } // if
        return tmp;
    } // deleteUsuario

    public Usuario updateUsuario(Long id, String password, String newPassword) throws Exception {
        Optional<Usuario> tmp = usuarioRepository.findById(id);
        if (tmp.isPresent()) {
            Usuario usuario = tmp.get();
            if (usuario.getContrasena() == password) {
                usuario.setContrasena(newPassword);
                usuarioRepository.save(usuario);
                return usuario;
            }

        } else {
            System.out.println("Update - El Usuario con el id " + id + "no existe");
        } // if
        throw new Exception("Error al cambiar la contraseña");
    } // updateUsuario

    public Usuario addOrden(Long id, Ordenes ordenes) throws UserNotFound {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            ordenes.setUsuario(usuario);
            List<Ordenes> listaOrdenes = usuario.getOrdenes();
            listaOrdenes.add(ordenes);
            usuario.setOrdenes(listaOrdenes);
            usuarioRepository.save(usuario);
            return usuario;
        }
        throw new UserNotFound("Usuario con id " + id + " no se ha encontrado");
    }

}


