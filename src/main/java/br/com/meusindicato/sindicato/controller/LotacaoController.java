package br.com.meusindicato.sindicato.controller;

import br.com.meusindicato.sindicato.dto.LotacaoDTO;
import br.com.meusindicato.sindicato.service.LotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lotacao")
public class LotacaoController {

    @Autowired
    private LotacaoService lotacaoService;

    @PostMapping()
    public ResponseEntity<Boolean> cadastraLotacao(@RequestBody LotacaoDTO lotacaoDTO){

        return lotacaoService.cadastraLotacao(lotacaoDTO);
    }
}
