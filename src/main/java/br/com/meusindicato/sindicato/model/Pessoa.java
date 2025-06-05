package br.com.meusindicato.sindicato.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pessoaId")
    private Long pessoaId;

    @Column(name = "nomeCompleto")
    private String nomeCompleto;

    @OneToMany(mappedBy = "pessoa")
    private List<Sindicalista> sindicalistaList;

    @Column(unique = true)
    private Integer rg;

    @Column(name = "orgaoExpedidor")
    private String orgaoExpedidor;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataEmissaoRg;

    private Integer cep;

    private String endereco;

    private String bairro;

    @ManyToOne
    @JoinColumn(name = "cidadeAtualId")
    private Cidade cidadeAtual;

    @ManyToOne
    @JoinColumn(name = "cidadeNaturalId")
    private Cidade cidadeNatural;

    private String email;

    private String telefone;

    private String celular;

    private String watsapp;

    @ManyToOne
    @JoinColumn(name = "formacaoId")
    private Formacao formacao;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    private EstadoCivil estadoCivil;

    private String nomeMae;

    private String nomePai;

    @Enumerated(EnumType.STRING)
    private Nivel nivel;

    @Enumerated(EnumType.STRING)
    private Classe classe;

    @Column(length = 3)
    private Integer padrao;

    @ManyToOne
    @JoinColumn(name = "cargoId")
    private Cargo cargo;

    @OneToMany(mappedBy = "pessoa")
    private List<Dependentes> dependentes;

    @ManyToOne
    @JoinColumn(name = "lotacaoId")
    private Lotacao lotacao;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataFiliacao;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Pessoa() {}

    public Pessoa(String nomeCompleto,Integer rg,String orgaoExpedidor, Date dataEmissaoRg, Integer cep, String endereco, String bairro, Cidade cidadeAtual, Cidade cidadeNatural, String email, String telefone, String celular, String watsapp, Formacao formacao, Date dataNascimento, Sexo sexo, EstadoCivil estadoCivil, String nomeMae, String nomePai, Nivel nivel, Classe classe, Integer padrao, Cargo cargo, Lotacao lotacao, Date dataFiliacao, Status status) {
        this.nomeCompleto = nomeCompleto;
        this.rg = rg;
        this.orgaoExpedidor = orgaoExpedidor;
        this.dataEmissaoRg = dataEmissaoRg;
        this.cep = cep;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidadeAtual = cidadeAtual;
        this.cidadeNatural = cidadeNatural;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.watsapp = watsapp;
        this.formacao = formacao;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.nivel = nivel;
        this.classe = classe;
        this.padrao = padrao;
        this.cargo = cargo;
        this.lotacao = lotacao;
        this.dataFiliacao = dataFiliacao;
        this.status = status;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public List<Sindicalista> getSindicalistaList() {
        return sindicalistaList;
    }

    public void setSindicalistaList(List<Sindicalista> sindicalistaList) {
        this.sindicalistaList = sindicalistaList;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public String getOrgaoExpedidor() {
        return orgaoExpedidor;
    }

    public void setOrgaoExpedidor(String orgaoExpedidor) {
        this.orgaoExpedidor = orgaoExpedidor;
    }

    public Date getDataEmissaoRg() {
        return dataEmissaoRg;
    }

    public void setDataEmissaoRg(Date dataEmissaoRg) {
        this.dataEmissaoRg = dataEmissaoRg;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidadeAtual() {
        return cidadeAtual;
    }

    public void setCidadeAtual(Cidade cidadeAtual) {
        this.cidadeAtual = cidadeAtual;
    }

    public Cidade getCidadeNatural() {
        return cidadeNatural;
    }

    public void setCidadeNatural(Cidade cidadeNatural) {
        this.cidadeNatural = cidadeNatural;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getWatsapp() {
        return watsapp;
    }

    public void setWatsapp(String watsapp) {
        this.watsapp = watsapp;
    }

    public Formacao getFormacao() {
        return formacao;
    }

    public void setFormacao(Formacao formacao) {
        this.formacao = formacao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Dependentes> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Dependentes> dependentes) {
        this.dependentes = dependentes;
    }

    public Lotacao getLotacao() {
        return lotacao;
    }

    public void setLotacao(Lotacao lotacao) {
        this.lotacao = lotacao;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Integer getPadrao() {
        return padrao;
    }

    public void setPadrao(Integer padrao) {
        this.padrao = padrao;
    }

    public Date getdataFiliacao() {
        return dataFiliacao;
    }

    public void setdataFiliacao(Date dataFiliacao) {
        this.dataFiliacao = dataFiliacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "pessoaId=" + pessoaId +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", sindicalistaList=" + sindicalistaList +
                ", rg=" + rg +
                ", orgaoExpedidor='" + orgaoExpedidor + '\'' +
                ", dataEmissaoRg=" + dataEmissaoRg +
                ", cep=" + cep +
                ", endereco='" + endereco + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidadeAtual=" + cidadeAtual +
                ", cidadeNatural=" + cidadeNatural +
                ", email='" + email + '\'' +
                ", telefone=" + telefone +
                ", celular=" + celular +
                ", watsapp=" + watsapp +
                ", formacao=" + formacao +
                ", dataNascimento=" + dataNascimento +
                ", sexo=" + sexo +
                ", estadoCivil=" + estadoCivil +
                ", nomeMae='" + nomeMae + '\'' +
                ", nomePai='" + nomePai + '\'' +
                ", nivel=" + nivel +
                ", classe=" + classe +
                ", padrao=" + padrao +
                ", cargo=" + cargo +
                ", dependentes=" + dependentes +
                ", lotacao=" + lotacao +
                ", dataFiliacao=" + dataFiliacao +
                ", status=" + status +
                '}';
    }
}