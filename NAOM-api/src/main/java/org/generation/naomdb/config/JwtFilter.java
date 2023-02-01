package org.generation.naomdb.config;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JwtFilter extends GenericFilter {

    public static String secretKey = "w3b0sr4nch3r0skr3w";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String authHeader = httpServletRequest.getHeader("Authorization");
        if (("POST".equals(httpServletRequest.getMethod())) ||
                (("GET".equals(httpServletRequest.getMethod())) &&
                        (!httpServletRequest.getRequestURI().contains("/api/productos"))) ||
                ("PUT".equals(httpServletRequest.getMethod())) ||
                ("DELETE".equals(httpServletRequest.getMethod()))
        ) {
            if (authHeader == null || !authHeader.startsWith("Bearer: ")) {
                throw new ServletException("1. Invalid Token");
            }// if authHedaer

            String token = authHeader.substring(7);
            try {
                Claims claims = Jwts.parser().setSigningKey(secretKey)
                        .parseClaimsJws(token).getBody();
                claims.forEach((key, value) -> {
                    System.out.println("key: " + key + " value: " + value);
                });
            } catch (SignatureException | MalformedJwtException | ExpiredJwtException e) {
                throw new ServletException("2. Invalid Token.");
            }//catch
        }// if methods

        chain.doFilter(request, response);
    }
}
