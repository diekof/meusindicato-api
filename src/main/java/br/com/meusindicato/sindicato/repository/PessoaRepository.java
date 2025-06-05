package br.com.meusindicato.sindicato.repository;

import br.com.meusindicato.sindicato.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
}
