package org.generation.naomdb.helper;

import io.jsonwebtoken.Jwts;

import static org.generation.naomdb.config.JwtFilter.secretKey;

public class JwtParser {

    public static String getEmailFromToken(String token){
        return Jwts.parser().
                setSigningKey(secretKey).
                parseClaimsJws(token).
                getBody().
                getSubject();
    }
}
