package br.com.meusindicato.sindicato.service;

import br.com.meusindicato.sindicato.dto.FormacaoDTO;
import br.com.meusindicato.sindicato.model.Formacao;
import br.com.meusindicato.sindicato.repository.FormacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FormacaoService {

    @Autowired
    FormacaoRepository formacaoRepository;

    public ResponseEntity<Boolean> cadastraFormacao(FormacaoDTO formacaoDTO) {
        Formacao formacao = new Formacao(formacaoDTO.formacaoCodigo(),formacaoDTO.nomeFormacao());

        formacaoRepository.save(formacao);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
}