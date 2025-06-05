package br.com.meusindicato.sindicato.repository;

import br.com.meusindicato.sindicato.model.Lotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LotacaoRepository extends JpaRepository<Lotacao,Long> {

    List<Lotacao> findByOrderByLotacaoDescricao();
}
