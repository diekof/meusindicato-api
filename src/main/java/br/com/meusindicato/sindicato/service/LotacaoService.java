package br.com.meusindicato.sindicato.service;

import br.com.meusindicato.sindicato.dto.LotacaoDTO;
import br.com.meusindicato.sindicato.model.Cargo;
import br.com.meusindicato.sindicato.model.Lotacao;
import br.com.meusindicato.sindicato.repository.LotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LotacaoService {

        @Autowired
        private LotacaoRepository lotacaoRepository;

    public ResponseEntity<Boolean> cadastraLotacao(LotacaoDTO lotacaoDTO) {

        Lotacao lotacao = new Lotacao(lotacaoDTO.lotacaoDescricao());
        lotacaoRepository.save(lotacao);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
}
