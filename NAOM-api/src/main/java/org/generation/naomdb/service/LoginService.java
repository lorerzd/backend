package org.generation.naomdb.service;

import org.generation.naomdb.exception.UserNotFound;
import org.generation.naomdb.dto.RegisterDTO;
import org.generation.naomdb.model.Usuario;
import org.generation.naomdb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class LoginService {

    private final UsuarioRepository usuarioRepository;

    public LoginService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Autowired
    BCryptPasswordEncoder passwordEncoder;



    public boolean logIn(String email, String password) throws UserNotFound {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreo(email);
        if(usuarioOpt.isPresent()){
            Usuario usuario = usuarioOpt.get();
            if(passwordEncoder.matches(password,usuario.getContrasena())){
                return true;
            }
        }else {
            throw new UserNotFound("Usuario con email "+email+" no se ha encontrado");
        }
        return false;
    }

    public Usuario register(@RequestBody RegisterDTO registerDTO) {
        Usuario usuario = userMapper(registerDTO);
        String rawPassword = usuario.getContrasena();
        String encodedPassword = passwordEncoder.encode(rawPassword);
        usuario.setContrasena(encodedPassword);
        return usuarioRepository.save(usuario);
    } // addUsuario

    public Usuario userMapper(RegisterDTO registerDTO){
        Usuario usuario = new Usuario();
        usuario.setNombre(registerDTO.getNombre());
        usuario.setApellido(registerDTO.getApellido());
        usuario.setCorreo(registerDTO.getCorreo());
        usuario.setContrasena(registerDTO.getContrasena());
        usuario.setTelefono(registerDTO.getTelefono());
        return usuario;
    }
}
