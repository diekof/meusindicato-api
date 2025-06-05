package br.com.meusindicato.sindicato.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "REFRESH_TOKENS")
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    
    @Column(name="refreshtoken")
    private String refreshToken;
    
    @Column(name="expirydate")
    private Date expiryDate;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "SecUserId")
    private SecUser userInfo;
    
    // Construtores e outros métodos...

    public RefreshToken() {
    }

    private RefreshToken(Builder builder) {
        this.refreshToken = builder.refreshToken;
        this.userInfo = builder.userInfo;
        this.expiryDate = builder.expiryDate;
    }

    // Método builder
    public static Builder builder() {
        return new Builder();
    }

    // Classe Builder
    public static class Builder {
        private String refreshToken;
        private SecUser userInfo;
        private Date expiryDate;

        public Builder refreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
            return this;
        }

        public Builder userInfo(SecUser userInfo) {
            this.userInfo = userInfo;
            return this;
        }

        public Builder expiryDate(Date expiryDate) {
            this.expiryDate = expiryDate;
            return this;
        }

        public RefreshToken build() {
            return new RefreshToken(this);
        }
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public SecUser getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(SecUser userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RefreshToken other = (RefreshToken) obj;
        return id == other.id;
    }

    @Override
    public String toString() {
        return "RefreshToken [id=" + id + ", refreshToken=" + refreshToken + ", expiryDate=" + expiryDate
                + ", userInfo=" + userInfo + "]";
    }
}
