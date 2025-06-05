package br.com.meusindicato.sindicato.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estadoId")
    private Long estadoId;

    @Column(name = "estadonome",unique = true,length = 30)
    private String estadoNome;

    @Column(length = 2)
    private String UF;

    @OneToMany(mappedBy = "estado",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Cidade> cidades;

    @ManyToOne
    @JoinColumn(name = "paisId")
    private Pais pais;

    public Estado(){}

    public Estado(String estadoNome, String UF, Pais pais) {
        this.estadoNome = estadoNome;
        this.UF = UF;
        this.pais = pais;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }

    public String getEstadoNome() {
        return estadoNome;
    }

    public void setEstadoNome(String estadoNome) {
        this.estadoNome = estadoNome;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "estadoId=" + estadoId +
                ", estadoNome='" + estadoNome + '\'' +
                ", UF='" + UF + '\'' +
                ", cidades=" + cidades +
                ", pais=" + pais +
                '}';
    }
}
