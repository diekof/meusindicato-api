package br.com.meusindicato.sindicato.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "SecRole")
public class SecRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SecRoleId")
    private Short id;

    @Column(name = "SecRoleName", nullable = false, length = 40)
    private String name;

    @Column(name = "SecRoleDescription", nullable = false, length = 120)
    private String description;

    // Getters e Setters
    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
