package br.com.meusindicato.sindicato.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Sindicalista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sindicalistaId")
    private Long sindicalistaId;

    @Column(unique = true)
    private Long matricula;

    @ManyToOne
    @JoinColumn(name = "pessoaId")
    private Pessoa pessoa;

    private Date dataAdmissao;

    private Date dataEncerramento;

}
