package br.com.meusindicato.sindicato.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CargoDTO( Long cargoId,
                        Integer cargoCodigo,
                        String cargoDescricao) {
}
