package br.com.meusindicato.sindicato.repository;

import br.com.meusindicato.sindicato.model.SecUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SecUserRepository extends JpaRepository<SecUser, Long> {

    @Query("SELECT u FROM SecUser u WHERE u.username = :username")
    Optional<SecUser> findByUsername(String username);

    @Query("SELECT u FROM SecUser u WHERE u.username = :username AND u.password = :password")
    Optional<SecUser> findByUserNameAndPassword(String username, String password);

    Page<SecUser> findAll(Specification<SecUser> spec, Pageable pageable);
}
