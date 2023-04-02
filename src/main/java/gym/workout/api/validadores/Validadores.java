package gym.workout.api.validadores;

import gym.workout.api.dto.DadosAgendamentoTreino;
import gym.workout.api.repositories.AgendamentoRepository;

public interface Validadores {
    void validar(DadosAgendamentoTreino dados, AgendamentoRepository agendamentoRepository);
}
