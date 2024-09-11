package br.com.jarvis.plusoft.controllers;

import br.com.jarvis.plusoft.dto.auth.DadosAutenticacaoDto;
import br.com.jarvis.plusoft.dto.auth.DadosTokenJwtDto;
import br.com.jarvis.plusoft.model.Cliente;
import br.com.jarvis.plusoft.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity<DadosTokenJwtDto> login(@RequestBody DadosAutenticacaoDto dados){
        var token = new UsernamePasswordAuthenticationToken(dados.email(), dados.password());
        var authentication = manager.authenticate(token);
        var tokenJwt = tokenService.gerarToken((Cliente) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJwtDto(tokenJwt));
    }


}
