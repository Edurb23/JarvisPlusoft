package br.com.jarvis.plusoft.service;

import br.com.jarvis.plusoft.model.Cliente;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.time.Duration;
import java.time.Instant;

@Service
public class TokenService {

    @Value("${api.token.secret}")
    private String passwordToken;

    public String generateToken(Cliente cliente) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(passwordToken);
            return JWT.create()
                    .withIssuer("API Downtown")
                    .withSubject(cliente.getEmail())
                    .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException("Error generating JWT token", e);
        }
    }

    public String getSubject(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(passwordToken);
            return JWT.require(algorithm)
                    .withIssuer("API Downtown")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e){
            throw new RuntimeException("Não foi possível validar o TokenJWT");
        }
    }
}
