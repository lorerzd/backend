package org.generation.naomdb.controller;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.generation.naomdb.config.JwtFilter;
import org.generation.naomdb.exception.UserNotFound;
import org.generation.naomdb.dto.LoginDTO;
import org.generation.naomdb.dto.RegisterDTO;
import org.generation.naomdb.model.Token;
import org.generation.naomdb.model.Usuario;
import org.generation.naomdb.service.LoginService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("api/auth")
@CrossOrigin(origins = "*")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public Token logIn(@RequestBody LoginDTO loginDTO) throws UserNotFound, ServletException {
        if(loginService.logIn(loginDTO.getCorreo(),loginDTO.getContrasena())){
            return new Token(generateToken(loginDTO.getCorreo()));
        }
        throw new ServletException("Error al intentar iniciar sesion");
    }

    @PostMapping("/register")
    public Usuario register(@RequestBody RegisterDTO registerDTO){
        return loginService.register(registerDTO);
    }

    private String generateToken(String email) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 12);
        return Jwts.builder().setSubject(email).claim("role", "user")
                .setIssuedAt(new Date()).setExpiration(calendar.getTime())
                .signWith(SignatureAlgorithm.HS256, JwtFilter.secretKey).compact();
    }
}
