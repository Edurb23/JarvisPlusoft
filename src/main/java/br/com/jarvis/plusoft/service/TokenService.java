package br.com.jarvis.plusoft.service;

import br.com.jarvis.plusoft.model.Cliente;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class TokenService {

    @Value("${api.token.secret}")
    private String senhaToken;



    public String gerarToken(Cliente cliente){
        try {
            Algorithm algoritmo = Algorithm.HMAC256(senhaToken);
            return JWT.create()
                    .withIssuer("API DOWNTOWN")
                    .withSubject(cliente.getEmail())
                    .withExpiresAt(Instant.now().plus(Duration.ofMinutes(15)))
                    .sign(algoritmo);
        } catch (JWTCreationException e){
            throw new RuntimeException("Erro ao gerar token jwt");
        }
    }



}
