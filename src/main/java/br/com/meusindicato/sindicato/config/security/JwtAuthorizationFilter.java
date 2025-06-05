package br.com.meusindicato.sindicato.config.security;

import br.com.meusindicato.sindicato.service.JwtService;
import br.com.meusindicato.sindicato.service.SecUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final ObjectMapper mapper;
    private final SecUserService usuarioService;
    private final JwtService jwtService;
    private final UserDetailsServiceImpl userDetailsServiceImpl;

    public JwtAuthorizationFilter(JwtUtil jwtUtil, ObjectMapper mapper,SecUserService usuarioService, JwtService jwtService, UserDetailsServiceImpl userDetailsServiceImpl) {
        this.jwtUtil = jwtUtil;
        this.mapper = mapper;

        this.usuarioService = usuarioService;
        this.jwtService = jwtService;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;
        if(authHeader != null && authHeader.startsWith("Bearer ")){
            token = authHeader.substring(7);
            try {
                username = jwtService.extractUsername(token);
                if( username != null && SecurityContextHolder.getContext().getAuthentication() == null){
                    UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);
                    if(jwtService.validateToken(token, userDetails)){
                        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    }
                }
            }catch(Exception e) {
                Map<String, Object> errorDetails = new HashMap<>();
                errorDetails.put("message", "token expirado");
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);

                mapper.writeValue(response.getWriter(), errorDetails);
            }

        }
        try{
            filterChain.doFilter(request, response);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}