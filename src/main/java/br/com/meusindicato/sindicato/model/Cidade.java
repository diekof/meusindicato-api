package br.com.meusindicato.sindicato.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cidadeId")
    private Long cidadeId;

    @Column(length = 150)
    private String cidadeNome;

    @ManyToOne
    @JoinColumn(name = "estadoId")
    private Estado estado;

    @OneToMany(mappedBy = "cidadeAtual",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Pessoa> cidadePessoas;

    @OneToMany(mappedBy = "cidadeNatural",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Pessoa> cidadeNaturalPessoas;

    public Cidade(){}

    public Cidade(String cidadeNome,Estado estado ) {
        this.cidadeNome = cidadeNome;
        this.estado = estado;
    }

    public Long getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Long cidadeId) {
        this.cidadeId = cidadeId;
    }

    public String getCidadeNome() {
        return cidadeNome;
    }

    public void setCidadeNome(String cidadeNome) {
        this.cidadeNome = cidadeNome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Pessoa> getCidadePessoas() {
        return cidadePessoas;
    }

    public void setCidadePessoas(List<Pessoa> cidadePessoas) {
        this.cidadePessoas = cidadePessoas;
    }

    public List<Pessoa> getCidadeNaturalPessoas() {
        return cidadeNaturalPessoas;
    }

    public void setCidadeNaturalPessoas(List<Pessoa> cidadeNaturalPessoas) {
        this.cidadeNaturalPessoas = cidadeNaturalPessoas;
    }
}
