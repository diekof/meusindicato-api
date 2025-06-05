package br.com.meusindicato.sindicato.repository;

import br.com.meusindicato.sindicato.model.RefreshToken;
import br.com.meusindicato.sindicato.model.SecUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Integer> {

    Optional<RefreshToken> findByRefreshToken(String token);

    @Query("DELETE FROM RefreshToken")
    void delete();

    @Modifying
    @Query("DELETE FROM RefreshToken rt WHERE rt.userInfo = :user")
    void deleteByUserInfo(@Param("user") SecUser user);


}

