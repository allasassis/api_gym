package gym.workout.api.controllers;

import gym.workout.api.dto.DadosAgendamentoTreino;
import gym.workout.api.dto.DadosDetalhamentoAgendamento;
import gym.workout.api.models.Agendamento;
import gym.workout.api.validadores.ValidacaoAgendamento;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    @Autowired
    private ValidacaoAgendamento validacaoAgendamento;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoAgendamento> agendar(@RequestBody DadosAgendamentoTreino dados, UriComponentsBuilder uriB) {
        Agendamento agendamento = validacaoAgendamento.agendar(dados);
        URI uri = uriB.path("/agendamento/{id}").buildAndExpand(agendamento.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoAgendamento(agendamento));
    }
}
