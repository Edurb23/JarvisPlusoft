package br.com.jarvis.plusoft.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "API da loja de roupas Downtown",
                description = "Especificação dos endpoints",
                version = "1.0",
                contact = @Contact(name = "Edu", email = "rm551987@fiap.com")
        ),
        security = @SecurityRequirement(name = "bearerJWT"),
        servers = {
                @Server(description = "Dev Env", url = "http://localhost:8080")
        }
)
@SecurityScheme(
        name = "bearerJWT",
        description = "Autenticação por Token JWT",
        scheme = "bearer",
        bearerFormat = "JWT",
        type = SecuritySchemeType.HTTP,
        in = SecuritySchemeIn.HEADER
)

public class OpenApiConfig {
}
