package br.com.meusindicato.sindicato.controller;

import br.com.meusindicato.sindicato.config.exceptions.ApiException;
import br.com.meusindicato.sindicato.config.security.JwtUtil;
import br.com.meusindicato.sindicato.dto.JwtRes;
import br.com.meusindicato.sindicato.dto.LoginReq;
import br.com.meusindicato.sindicato.dto.RefreshTokenReq;
import br.com.meusindicato.sindicato.model.RefreshToken;
import br.com.meusindicato.sindicato.service.JwtService;
import br.com.meusindicato.sindicato.service.RefreshTokenService;
import br.com.meusindicato.sindicato.service.SecUserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthResource {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final SecUserService usuarioService;
    private final RefreshTokenService refreshTokenService;
    private final JwtService jwtService;

    public AuthResource(
            AuthenticationManager authenticationManager,
            JwtUtil jwtUtil,
            SecUserService usuarioService,
            RefreshTokenService refreshTokenService,
            JwtService jwtService
    ) {

        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.usuarioService = usuarioService;
        this.refreshTokenService = refreshTokenService;
        this.jwtService = jwtService;
    }

    @ResponseBody
    @PostMapping("/login")
    @Operation(summary = "Autenticação", description = "Endpoint público para autenticação")
    public JwtRes login(@RequestBody LoginReq loginReq, HttpServletResponse response)  {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.username(), loginReq.password()));
            RefreshToken refreshToken = refreshTokenService.createRefreshToken(loginReq.username());
            return JwtRes.builder()
                    .accessToken(jwtService.GenerateToken(loginReq.username()))
                    .refreshToken(refreshToken.getRefreshToken()).build();

        }catch (BadCredentialsException e){
            throw new ApiException("Invalid usernamae or password");
        }

    }

    @PostMapping("/refreshToken")
    @Operation(summary = "Autenticação", description = "Endpoint público para recriar o token")
    public JwtRes refreshToken(@RequestBody RefreshTokenReq refreshTokenRequestDTO, HttpServletResponse response){
        return refreshTokenService.findByToken(refreshTokenRequestDTO.refreshToken())
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUserInfo)
                .map(userInfo -> {
                    String accessToken = jwtService.GenerateToken(userInfo.getUsername());
                    return JwtRes.builder()
                            .accessToken(accessToken)
                            .refreshToken(refreshTokenRequestDTO.refreshToken()).build();
                }).orElseThrow(() ->{
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    throw new RuntimeException("Refresh Token is not in DB..!!");
                });
    }
}
