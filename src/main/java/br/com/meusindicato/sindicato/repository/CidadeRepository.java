package br.com.meusindicato.sindicato.repository;

import br.com.meusindicato.sindicato.model.Cidade;
import br.com.meusindicato.sindicato.model.Estado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Long> {

    Page<Cidade> findAll(Specification<Cidade> spec, Pageable pageable);
}
