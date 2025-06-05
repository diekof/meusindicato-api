package br.com.meusindicato.sindicato.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PaisDTO(Long paisId,
                      String nome,
                      String sigla) {
}
