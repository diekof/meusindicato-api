package br.com.meusindicato.sindicato.service;

import br.com.meusindicato.sindicato.model.RefreshToken;
import br.com.meusindicato.sindicato.model.SecUser;
import br.com.meusindicato.sindicato.repository.RefreshTokenRepository;
import br.com.meusindicato.sindicato.repository.SecUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class RefreshTokenService {

    @Autowired
    RefreshTokenRepository refreshTokenRepository;

    @Autowired
    SecUserRepository userRepository;
    private long refreshTokenValidity = 60*4;

    @Transactional
    public RefreshToken createRefreshToken(String username){
        Optional<SecUser> user = userRepository.findByUsername(username);
        user.ifPresent(secUser -> refreshTokenRepository.deleteByUserInfo(secUser));

        Date tokenCreateTime = new Date();
        Date tokenValidity = new Date(tokenCreateTime.getTime() + TimeUnit.MINUTES.toMillis(refreshTokenValidity));

        RefreshToken refreshToken = RefreshToken
                .builder()
                .userInfo(userRepository.findByUsername(username).get())
                .refreshToken(UUID.randomUUID().toString())
                .expiryDate(tokenValidity)
                .build();
        return refreshTokenRepository.save(refreshToken);
    }



    public Optional<RefreshToken> findByToken(String token){
        return refreshTokenRepository.findByRefreshToken(token);
    }

    public RefreshToken verifyExpiration(RefreshToken token){
        System.out.println(token.getExpiryDate());
        System.out.println(Instant.now());
        if(token.getExpiryDate().before(new Date())){
            refreshTokenRepository.delete(token);
            throw new RuntimeException(token.getRefreshToken() + " Refresh token is expired. Please make a new login..!");
        }
        return token;

    }

}

