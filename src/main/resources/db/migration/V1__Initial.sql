CREATE TABLE IF NOT EXISTS pessoa(
    pessoa_id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    jornada integer not null default 8
);

CREATE TABLE IF NOT EXISTS banco_de_horas(
    banco_de_horas_id SERIAL PRIMARY KEY,
    pessoa_id INTEGER NOT NULL,
    dia TIMESTAMP WITH TIME ZONE NOT NULL,
    horas INTERVAL NOT NULL,
    FOREIGN KEY (pessoa_id)
      REFERENCES pessoa (pessoa_id)
);

CREATE TABLE IF NOT EXISTS bate_ponto(
    pessoa_id INTEGER NOT NULL,
    horario_inicio TIMESTAMP WITH TIME ZONE NOT NULL,
    horario_fim TIMESTAMP WITH TIME ZONE,
    PRIMARY KEY (pessoa_id,horario_inicio),
    FOREIGN KEY (pessoa_id)
      REFERENCES pessoa (pessoa_id)
);