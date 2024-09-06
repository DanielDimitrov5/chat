package com.example.chatservice.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.List;
import java.util.Map;

@Configuration
public class WebSocketAuthInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        // Extract token from the request header (e.g., "Authorization: Bearer <token>")
        List<String> authorization = request.getHeaders().get("Authorization");

        if (authorization != null && !authorization.isEmpty()) {
            String token = authorization.get(0).replace("Bearer ", "");

            if (token != null && validateToken(token)) {
                Claims claims = Jwts.parser()
                        .setSigningKey("0x5A10ee08e35B699E8c46c6DE92a82e135DCbb5d3df3")  // Use a secure secret key
                        .parseClaimsJws(token)
                        .getBody();

                attributes.put("user", claims.getSubject()); // Set user details in attributes
                return true;
            }
        }
        return false;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
        // Nothing to implement here, unless you want to handle any post-handshake logic
    }

    private boolean validateToken(String token) {
        // Implement token validation logic (this is a stub for demonstration)
        try {
            Jwts.parser().setSigningKey("yourSecretKey").parseClaimsJws(token); // Token validation logic
            return true;
        } catch (Exception e) {
            return false; // Token is invalid
        }
    }
}
