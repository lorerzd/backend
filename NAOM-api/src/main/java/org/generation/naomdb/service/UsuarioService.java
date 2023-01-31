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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;

    private final OrdenesRepository ordenesRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, OrdenesRepository ordenesRepository) {
        this.usuarioRepository = usuarioRepository;
        this.ordenesRepository = ordenesRepository;
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    } // getAllUsuarios

    public Usuario getUsuario(String email) {
        return usuarioRepository.findByCorreo(email).orElseThrow(
                () -> new IllegalArgumentException("El Usuario con el correo " + email + " no existe.")
        );
    }// getUsuario


    public Usuario deleteUsuario(String email) throws UserNotFound {
        Optional<Usuario> tmp = usuarioRepository.findByCorreo(email);
        if (tmp.isPresent()) {
            usuarioRepository.deleteByCorreo(email);
            return tmp.get();
        } // if
        throw new UserNotFound("Usuario con el email "+email+" no se ha encontrado");
    } // deleteUsuario

    public Usuario updateUsuario(String email, String password, String newPassword) throws Exception {
        Optional<Usuario> tmp = usuarioRepository.findByCorreo(email);
        if (tmp.isPresent()) {
            Usuario usuario = tmp.get();
            if (passwordEncoder.matches(password,usuario.getContrasena())){
                usuario.setContrasena(passwordEncoder.encode(newPassword));
                usuarioRepository.save(usuario);
                return usuario;
            }
        } else {
            System.out.println("Update - El Usuario con el correo " + email + "no existe");
        } // if
        throw new Exception("Error al cambiar la contraseña");
    } // updateUsuario

    public Usuario addOrden(String email, Ordenes ordenes) throws UserNotFound {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreo(email);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            ordenes.setUsuario(usuario);
            List<Ordenes> listaOrdenes = usuario.getOrdenes();
            listaOrdenes.add(ordenes);
            usuario.setOrdenes(listaOrdenes);
            usuarioRepository.save(usuario);
            return usuario;
        }
        throw new UserNotFound("Usuario con correo " + email + " no se ha encontrado");
    }

}


