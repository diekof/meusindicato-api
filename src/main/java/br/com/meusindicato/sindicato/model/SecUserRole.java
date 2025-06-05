package br.com.meusindicato.sindicato.model;

import jakarta.persistence.*;

@Entity
@Table(name = "SecUserRole")
public class SecUserRole {

    @EmbeddedId
    private SecUserRoleId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("secUserId")
    @JoinColumn(name = "SecUserId", referencedColumnName = "SecUserId")
    private SecUser user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("secRoleId")
    @JoinColumn(name = "SecRoleId", referencedColumnName = "SecRoleId")
    private SecRole role;

    public SecUserRole() {}

    public SecUserRole(SecUser user, SecRole role) {
        this.user = user;
        this.role = role;
        this.id = new SecUserRoleId(user.getId().shortValue(), role.getId());
    }

    public SecUserRoleId getId() {
        return id;
    }

    public void setId(SecUserRoleId id) {
        this.id = id;
    }

    public SecUser getUser() {
        return user;
    }

    public void setUser(SecUser user) {
        this.user = user;
    }

    public SecRole getRole() {
        return role;
    }

    public void setRole(SecRole role) {
        this.role = role;
    }
}
