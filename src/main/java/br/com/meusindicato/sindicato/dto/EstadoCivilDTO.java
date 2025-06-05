package br.com.meusindicato.sindicato.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record EstadoCivilDTO(String estadoCivil) {
}