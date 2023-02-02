package org.generation.naomdb.helper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import static org.generation.naomdb.config.JwtFilter.secretKey;

public class TokenHelper {

    public static String getTokenFromHeader(HttpServletRequest request) throws ServletException {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer: ")) {
            throw new ServletException("1. Invalid Token");
        }// if authHedaer
        return authHeader.substring(7);
    }

    public static String getEmailFromToken(String token){
        return Jwts.parser().
                setSigningKey(secretKey).
                parseClaimsJws(token).
                getBody().
                getSubject();
    }

    public static String getUserRole(String token){
        return Jwts.parser().setSigningKey(secretKey)
                .parseClaimsJws(token).getBody().get("role").toString();
    }
}
