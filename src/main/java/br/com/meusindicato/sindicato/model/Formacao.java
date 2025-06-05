package br.com.meusindicato.sindicato.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Formacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "formacaoId")
    private Long formacaoId;

    private String nomeFormacao;

    @Column(name = "formacaoCodigo",unique = true)
    private Integer formacaoCodigo;

    @OneToMany(mappedBy = "formacao",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Pessoa> formacaoPessoas;

    public Formacao(){}

    public Formacao(Integer codigoFormacao,String nomeFormacao) {
        this.nomeFormacao = nomeFormacao;
        this.formacaoCodigo = codigoFormacao;
    }

    public Long getFormacaoId() {
        return formacaoId;
    }

    public void setFormacaoId(Long formacaoId) {
        this.formacaoId = formacaoId;
    }

    public String getNomeFormacao() {
        return nomeFormacao;
    }

    public void setNomeFormacao(String nomeFormacao) {
        this.nomeFormacao = nomeFormacao;
    }

    public Integer getFormacaoCodigo() {
        return formacaoCodigo;
    }

    public void setFormacaoCodigo(Integer formacaoCodigo) {
        this.formacaoCodigo = formacaoCodigo;
    }

    public List<Pessoa> getFormacaoPessoas() {
        return formacaoPessoas;
    }

    public void setFormacaoPessoas(List<Pessoa> formacaoPessoas) {
        this.formacaoPessoas = formacaoPessoas;
    }

    @Override
    public String toString() {
        return "Formacao{" +
                "formacaoId=" + formacaoId +
                ", nomeFormacao='" + nomeFormacao + '\'' +
                ", codigoFormacao=" + formacaoCodigo +
                ", formacaoPessoas=" + formacaoPessoas +
                '}';
    }
}
