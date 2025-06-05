package br.com.meusindicato.sindicato.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cargoId")
    private Long cargoId;

    private Integer cargoCodigo;

    @Column(name = "cargoDescricao")
    private String cargoDescricao;

    @OneToMany(mappedBy = "cargo")
    private List<Pessoa> pessoas;

    public Cargo(){}

    public Cargo(Integer cargoCodigo,String cargoDescricao) {
        this.cargoCodigo = cargoCodigo;
        this.cargoDescricao = cargoDescricao;
    }

    public Integer getCargoCodigo() {
        return cargoCodigo;
    }

    public void setCargoCodigo(Integer cargoCodigo) {
        this.cargoCodigo = cargoCodigo;
    }

    public String getCargoDescricao() {
        return cargoDescricao;
    }

    public void setCargoDescricao(String cargoDescricao) {
        this.cargoDescricao = cargoDescricao;
    }

    public Long getCargoId() {
        return cargoId;
    }

    public void setCargoId(Long cargoId) {
        this.cargoId = cargoId;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "cargoId=" + cargoId +
                ", cargoCodigo=" + cargoCodigo +
                ", cargoDescricao='" + cargoDescricao + '\'' +
                ", pessoas=" + pessoas +
                '}';
    }
}
