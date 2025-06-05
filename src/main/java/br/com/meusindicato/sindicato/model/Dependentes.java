package br.com.meusindicato.sindicato.model;

import jakarta.persistence.*;

@Entity
public class Dependentes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dependenteId")
    private Long dependenteId;

    private String dependenteNome;

    private GrauParentesco grau;

    @ManyToOne
    @JoinColumn(name = "pessoaId")
    private Pessoa pessoa;
}
