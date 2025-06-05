package br.com.meusindicato.sindicato.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paisId")
    private Long paisId;

    @Column(name = "nomePais",unique = true)
    private String nomePais;

    @Column(length = 3,nullable = true)
    private String siglaPais;

    @OneToMany(mappedBy = "pais")
    private List<Estado> estados;

    public Pais(){}

    public Pais(String nomePais, String siglaPais) {
        this.nomePais = nomePais;
        this.siglaPais = siglaPais;
    }

    public Long getPaisId() {
        return paisId;
    }

    public void setPaisId(Long paisId) {
        this.paisId = paisId;
    }

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }

    public String getSiglaPais() {
        return siglaPais;
    }

    public void setSiglaPais(String siglaPais) {
        this.siglaPais = siglaPais;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }
}
