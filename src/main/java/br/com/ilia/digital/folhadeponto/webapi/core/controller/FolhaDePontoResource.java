package br.com.ilia.digital.folhadeponto.webapi.core.controller;

import java.util.Optional;
import javax.validation.Valid;
import org.openapi.folhadeponto.server.api.V1Api;
import org.openapi.folhadeponto.server.model.Alocacao;
import org.openapi.folhadeponto.server.model.Momento;
import org.openapi.folhadeponto.server.model.Registro;
import org.openapi.folhadeponto.server.model.Relatorio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

@RestController
public class FolhaDePontoResource implements V1Api {

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @Override
    public ResponseEntity<Relatorio> geraRelatorioMensal(String mes) {
        return null;
    }

    @Override
    public ResponseEntity<Alocacao> insereAlocacao(@Valid Alocacao alocacao) {
        return null;
    }

    @Override
    public ResponseEntity<Registro> insereBatida(@Valid Momento momento) {
        return null;
    }
}
