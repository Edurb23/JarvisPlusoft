package br.com.jarvis.plusoft.controllers;

import br.com.jarvis.plusoft.dto.auth.DadosAuthDto;
import br.com.jarvis.plusoft.dto.auth.DadosTokenDto;
import br.com.jarvis.plusoft.dto.clienteDto.DetalhesClienteDto;
import br.com.jarvis.plusoft.model.Cliente;
import br.com.jarvis.plusoft.service.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Tag(name = "Auth", description = "Operações relacionadas ao Auth")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;


    @PostMapping
    @Transactional
    @Operation(summary = "lOGIN",
            description = "Efetua o login")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Login efetuado com Sucesso", content =
    @Content(schema = @Schema(implementation = DadosTokenDto.class), mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Não Autorizado ou Token Inválido", content =
                    { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")})
    public ResponseEntity<DadosTokenDto> login(@RequestBody DadosAuthDto dados){
        var token = new UsernamePasswordAuthenticationToken(dados.email(),dados.password());
        var authentication = manager.authenticate(token);
        var tokenJwt = tokenService.generateToken((Cliente) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenDto(tokenJwt));
    }


}
