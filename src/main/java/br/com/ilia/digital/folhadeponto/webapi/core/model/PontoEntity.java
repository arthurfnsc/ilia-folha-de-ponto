package br.com.ilia.digital.folhadeponto.webapi.core.model;

import br.com.ilia.digital.folhadeponto.webapi.core.model.id.PontoIdentifier;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "bate_ponto")
public class PontoEntity {

    @EmbeddedId
    private PontoIdentifier pontoIdentifier;

    @Column(name = "horario_fim")
    private Timestamp horarioFim;

    public PontoIdentifier getPontoIdentifier() {
        return pontoIdentifier;
    }

    public void setPontoIdentifier(PontoIdentifier pontoIdentifier) {
        this.pontoIdentifier = pontoIdentifier;
    }

    public Timestamp getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(Timestamp horarioFim) {
        this.horarioFim = horarioFim;
    }
}
