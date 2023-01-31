package org.generation.naomdb.controller;

import org.generation.naomdb.helper.AuthorizationToken;
import org.generation.naomdb.helper.JwtParser;
import org.generation.naomdb.exception.UserNotFound;
import org.generation.naomdb.dto.ChangePasswordDTO;
import org.generation.naomdb.model.Ordenes;
import org.generation.naomdb.model.Usuario;
import org.generation.naomdb.service.UsuarioService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        super();
        this.usuarioService = usuarioService;
    } // constructor

    @GetMapping
    public Usuario getUsuario(HttpServletRequest request) throws ServletException {
        String token = AuthorizationToken.getTokenFromHeader(request);
        return usuarioService.getUsuario(JwtParser.getEmailFromToken(token));
    } // getUsuario

    @DeleteMapping
    public Usuario deleteUsuario(HttpServletRequest request) throws ServletException, UserNotFound {
        String token = AuthorizationToken.getTokenFromHeader(request);
        return usuarioService.deleteUsuario(JwtParser.getEmailFromToken(token));
    } // deleteUsuario

    @PutMapping // http://localhost:8080/api/usuarios/1
    public Usuario updateUsuario(HttpServletRequest request, @RequestBody ChangePasswordDTO changepassword) throws Exception {
        String token = AuthorizationToken.getTokenFromHeader(request);
        return usuarioService.updateUsuario(
                JwtParser.getEmailFromToken(token),
                changepassword.getPassword(),
                changepassword.getNewPassword());
    } // updateUsuario

    @PostMapping(path = "/orden")
    public Usuario addOrden(@RequestBody Ordenes ordenes, HttpServletRequest request) throws UserNotFound, ServletException {
        String token = AuthorizationToken.getTokenFromHeader(request);
        return usuarioService.addOrden(
                JwtParser.getEmailFromToken(token),
                ordenes);
    }

} // class

