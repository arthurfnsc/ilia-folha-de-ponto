package br.com.ilia.digital.folhadeponto.webapi.core.model;

import org.postgresql.util.PGInterval;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "banco_de_horas")
public class BancoDeHorasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "banco_de_horas_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "pessoa_id")
    private PessoaEntity pessoa;

    @Column(name = "dia")
    private Timestamp dia;

    @Column(name = "horas", nullable = false)
    private PGInterval horas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PessoaEntity getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaEntity pessoa) {
        this.pessoa = pessoa;
    }

    public Timestamp getDia() {
        return dia;
    }

    public void setDia(Timestamp dia) {
        this.dia = dia;
    }

    public PGInterval getHoras() {
        return horas;
    }

    public void setHoras(PGInterval horas) {
        this.horas = horas;
    }
}
