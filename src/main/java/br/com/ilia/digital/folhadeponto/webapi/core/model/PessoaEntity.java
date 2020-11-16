package br.com.ilia.digital.folhadeponto.webapi.core.model;

import javax.persistence.*;

@Entity
@Table(name = "pessoa")
public class PessoaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pessoa_id", nullable = false)
    private Integer id;

    @Column(name = "nome", length = 255)
    private String nome;

    @Column(name = "jornada", nullable = false)
    private Integer jornada;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getJornada() {
        return jornada;
    }

    public void setJornada(Integer jornada) {
        this.jornada = jornada;
    }
}
