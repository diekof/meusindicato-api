package br.com.meusindicato.sindicato.controller;

import br.com.meusindicato.sindicato.dto.FormacaoDTO;
import br.com.meusindicato.sindicato.service.FormacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/formacao")
public class FormacaoController {

    @Autowired
    private FormacaoService formacaoService;

    @PostMapping("/formacao")
    public ResponseEntity<Boolean> cadastraFormacao(@RequestBody FormacaoDTO formacaoDTO){
        return formacaoService.cadastraFormacao(formacaoDTO);
    }
}
