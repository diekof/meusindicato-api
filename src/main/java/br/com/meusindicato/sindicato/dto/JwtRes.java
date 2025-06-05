package br.com.meusindicato.sindicato.dto;

import java.util.Objects;

public class JwtRes {
    private String accessToken;
    private String refreshToken;

    // Construtores, getters, e setters
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public JwtRes() {
        super();
    }

    public JwtRes(String accessToken, String refreshToken) {
        super();
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    // Métodos hashCode, equals e toString
    @Override
    public int hashCode() {
        return Objects.hash(accessToken, refreshToken);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        JwtRes other = (JwtRes) obj;
        return Objects.equals(accessToken, other.accessToken) && Objects.equals(refreshToken, other.refreshToken);
    }

    @Override
    public String toString() {
        return "JwtRes [accessToken=" + accessToken + ", refreshToken=" + refreshToken + "]";
    }

    // Implementação do método builder()
    public static Builder builder() {
        return new Builder();
    }

    // Classe Builder
    public static class Builder {
        private String accessToken;
        private String refreshToken;

        // Métodos para configurar as propriedades
        public Builder accessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        public Builder refreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
            return this;
        }

        // Método que cria o objeto JwtRes com as propriedades configuradas
        public JwtRes build() {
            return new JwtRes(this.accessToken, this.refreshToken);
        }
    }
}
