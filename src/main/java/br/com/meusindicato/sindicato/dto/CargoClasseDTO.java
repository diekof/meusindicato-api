package br.com.meusindicato.sindicato.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CargoClasseDTO(@JsonAlias("classe") String classe) {
}
