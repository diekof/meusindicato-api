package br.com.meusindicato.sindicato.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("config")
public class ConfigProperty {
    private String originPermitida = "http://localhost:4200";

    public String getOriginPermitida() {
        return originPermitida;
    }

    public void setOriginPermitida(String originPermitida) {
        this.originPermitida = originPermitida;
    }

}
