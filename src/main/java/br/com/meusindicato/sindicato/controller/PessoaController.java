package br.com.meusindicato.sindicato.controller;

import br.com.meusindicato.sindicato.dto.*;
import br.com.meusindicato.sindicato.model.Classe;
import br.com.meusindicato.sindicato.model.EstadoCivil;
import br.com.meusindicato.sindicato.model.Nivel;
import br.com.meusindicato.sindicato.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/buscaniveis")
    public List<NivelDTO> buscaNiveis(){

        return Arrays.stream(Nivel.values()).map(n -> new NivelDTO(n.getNivel()))
                .collect(Collectors.toList());
    }

    @GetMapping("/buscaclasses")
    public List<CargoClasseDTO> buscaClasses(){

        return Arrays.stream(Classe.values()).map(c -> new CargoClasseDTO(c.getClasse()))
                .collect(Collectors.toList());
    }

    @GetMapping("/estadocivil")
    public List<EstadoCivilDTO> buscaEstadoCivil(){

        return Arrays.stream(EstadoCivil.values()).map(e -> new EstadoCivilDTO(e.getEstadoCivil()))
                .collect(Collectors.toList());
    }

    @GetMapping("/pais")
    public List<PaisDTO> listaPaises(){

        return pessoaService.listaPaises();
    }

    @GetMapping("/estado/{paisId}")
    public List<EstadoDTO> listaEstados(@PathVariable Long paisId){
            return pessoaService.listaEstados(paisId);
    }

    @GetMapping("cidade/{estadoId}")
    public List<CidadeDTO> listaCidades(@PathVariable Long estadoId){
        return pessoaService.listaCidades(estadoId);
    }

    @GetMapping("/formacao")
    public List<FormacaoDTO> buscaFormacoes(){
        return pessoaService.listaFormacoes();
    }

    @GetMapping("/lotacao")
    public List<LotacaoDTO> listaLotacoes(){
       return pessoaService.listaLotacoes();
    }

    @GetMapping("/cargo")
    public List<CargoDTO> listaCargos(){
        return pessoaService.listaCargos();
    }

    @PostMapping("/pessoa")
    public ResponseEntity<Boolean> cadastraPessoa(@RequestBody PessoaDTO pessoaDTO){

        return pessoaService.cadastraPessoa(pessoaDTO);
    }
}
