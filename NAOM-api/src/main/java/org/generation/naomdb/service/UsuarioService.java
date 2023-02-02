package org.generation.naomdb.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.generation.naomdb.exception.UserNotFound;
import org.generation.naomdb.model.Ordenes;
import org.generation.naomdb.model.Producto;
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

    public Usuario updateUsuario(String correo,String nombre, String telefono, String actual, String nueva, String direccion) throws UserNotFound {
        Optional<Usuario> tmp = usuarioRepository.findByCorreo(correo);
        if (tmp.isPresent()) {
            Usuario usuario = tmp.get();
            if(correo != null) usuario.setCorreo(correo);
            if(nombre != null) usuario.setNombre(nombre);
            if(telefono != null) usuario.setTelefono(telefono);
            if(actual != null && nueva != null){
                if(passwordEncoder.matches(actual,usuario.getContrasena())){
                    usuario.setContrasena(passwordEncoder.encode(nueva));
                }
            }
            if(direccion != null) usuario.setDireccion(direccion);
            usuarioRepository.save(usuario);
            return usuario;
        }
        throw new UserNotFound("No se ha encontrado el usuario con el correo "+correo);
    }

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


