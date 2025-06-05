package br.com.meusindicato.sindicato.repository;

import br.com.meusindicato.sindicato.model.Formacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormacaoRepository extends JpaRepository<Formacao,Long> {

    List<Formacao> findByOrderByFormacaoCodigo();
}
