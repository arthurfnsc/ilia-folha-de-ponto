package br.com.ilia.digital.folhadeponto.webapi.core.model.id;

import br.com.ilia.digital.folhadeponto.webapi.core.model.PessoaEntity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Embeddable
public class PontoIdentifier implements Serializable {
    @ManyToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "pessoa_id")
    private PessoaEntity pessoaEntity;

    @Column(name = "horario_inicio", nullable = false)
    private Timestamp horarioInicio;

    public PessoaEntity getPessoaEntity() {
        return pessoaEntity;
    }

    public void setPessoaEntity(PessoaEntity pessoaEntity) {
        this.pessoaEntity = pessoaEntity;
    }

    public Timestamp getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Timestamp horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PontoIdentifier that = (PontoIdentifier) o;
        return Objects.equals(pessoaEntity, that.pessoaEntity) &&
                Objects.equals(horarioInicio, that.horarioInicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pessoaEntity, horarioInicio);
    }
}
