package br.com.meusindicato.sindicato.dto;

import br.com.meusindicato.sindicato.model.Pessoa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LotacaoDTO(Long lotacaoId,
                        String lotacaoDescricao) {
}
