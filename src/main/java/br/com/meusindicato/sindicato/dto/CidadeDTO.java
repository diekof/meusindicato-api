package br.com.meusindicato.sindicato.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CidadeDTO(Long cidadeId,
                        @JsonAlias("cidadeNome") String cidadeNome,
                        Long estadoId) {
}
