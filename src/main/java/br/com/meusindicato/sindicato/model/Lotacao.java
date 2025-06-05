package br.com.meusindicato.sindicato.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Lotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lotacaoId")
    private Long lotacaoId;

    private String lotacaoDescricao;

    @OneToMany(mappedBy = "lotacao")
    private List<Pessoa> pessoaList;

    public Lotacao() {}

    public Lotacao(String lotacaoDescricao) {
        this.lotacaoDescricao = lotacaoDescricao;
    }

    public Long getLotacaoId() {
        return lotacaoId;
    }

    public void setLotacaoId(Long lotacaoId) {
        this.lotacaoId = lotacaoId;
    }

    public String getLotacaoDescricao() {
        return lotacaoDescricao;
    }

    public void setLotacaoDescricao(String lotacaoDescricao) {
        this.lotacaoDescricao = lotacaoDescricao;
    }

    public List<Pessoa> getPessoas() {
        return pessoaList;
    }

    public void setPessoas(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    @Override
    public String toString() {
        return "Lotacao{" +
                "lotacaoId=" + lotacaoId +
                ", lotacaoDescricao='" + lotacaoDescricao + '\'' +
                ", pessoa=" + pessoaList +
                '}';
    }
}
