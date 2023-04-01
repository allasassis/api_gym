package gym.workout.api.validadores;

import gym.workout.api.dto.DadosAgendamentoTreino;
import gym.workout.api.models.Agendamento;
import gym.workout.api.repositories.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidacaoAgendamento {

    @Autowired
    private AgendamentoRepository repository;

    public Agendamento agendar(DadosAgendamentoTreino dados) {
        return null;
    }
}
