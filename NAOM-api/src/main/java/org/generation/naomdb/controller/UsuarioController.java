package org.generation.naomdb.controller;

import org.generation.naomdb.helper.TokenHelper;
import org.generation.naomdb.exception.UserNotFound;
import org.generation.naomdb.dto.ChangePasswordDTO;
import org.generation.naomdb.model.Ordenes;
import org.generation.naomdb.model.Usuario;
import org.generation.naomdb.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        super();
        this.usuarioService = usuarioService;
    } // constructor

    @GetMapping
    public Usuario getUsuario(HttpServletRequest request) throws ServletException {
        String token = TokenHelper.getTokenFromHeader(request);
        return usuarioService.getUsuario(TokenHelper.getEmailFromToken(token));
    } // getUsuario

    @DeleteMapping
    public Usuario deleteUsuario(HttpServletRequest request) throws ServletException, UserNotFound {
        String token = TokenHelper.getTokenFromHeader(request);
        return usuarioService.deleteUsuario(TokenHelper.getEmailFromToken(token));
    } // deleteUsuario

    @PutMapping // http://localhost:8080/api/usuarios/1
    public Usuario updateUsuario(HttpServletRequest request, @RequestBody ChangePasswordDTO changepassword) throws Exception {
        String token = TokenHelper.getTokenFromHeader(request);
        return usuarioService.updateUsuario(
                TokenHelper.getEmailFromToken(token),
                changepassword.getPassword(),
                changepassword.getNewPassword());
    } // updateUsuario

    @PostMapping(path = "/orden")
    public Usuario addOrden(@RequestBody Ordenes ordenes, HttpServletRequest request) throws UserNotFound, ServletException {
        String token = TokenHelper.getTokenFromHeader(request);
        return usuarioService.addOrden(
                TokenHelper.getEmailFromToken(token),
                ordenes);
    }

} // class

