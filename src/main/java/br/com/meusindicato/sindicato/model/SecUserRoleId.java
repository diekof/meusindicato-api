package br.com.meusindicato.sindicato.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SecUserRoleId implements Serializable {

    private Short secUserId;
    private Short secRoleId;

    public SecUserRoleId() {}

    public SecUserRoleId(Short secUserId, Short secRoleId) {
        this.secUserId = secUserId;
        this.secRoleId = secRoleId;
    }

    public Short getSecUserId() {
        return secUserId;
    }

    public void setSecUserId(Short secUserId) {
        this.secUserId = secUserId;
    }

    public Short getSecRoleId() {
        return secRoleId;
    }

    public void setSecRoleId(Short secRoleId) {
        this.secRoleId = secRoleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SecUserRoleId)) return false;
        SecUserRoleId that = (SecUserRoleId) o;
        return Objects.equals(secUserId, that.secUserId) && Objects.equals(secRoleId, that.secRoleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(secUserId, secRoleId);
    }
}

