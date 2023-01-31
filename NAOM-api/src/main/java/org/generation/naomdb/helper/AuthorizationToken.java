package org.generation.naomdb.helper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class AuthorizationToken {

    public static String getTokenFromHeader(HttpServletRequest request) throws ServletException {
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer: ")) {
            throw new ServletException("1. Invalid Token");
        }// if authHedaer
        return authHeader.substring(7);
    }
}
