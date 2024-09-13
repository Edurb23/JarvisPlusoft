package br.com.jarvis.plusoft.security;

import br.com.jarvis.plusoft.repository.ClienteRepository;
import br.com.jarvis.plusoft.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter  extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        if (token != null){
            token = token.replace("Bearer ", "");
            var subject = tokenService.getSubject(token);
            var cliente = clienteRepository.findByEmail(subject);
            var autenticationToken = new UsernamePasswordAuthenticationToken(cliente,
                    null, cliente.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(autenticationToken);
        }

        filterChain.doFilter(request, response);
    }


}
