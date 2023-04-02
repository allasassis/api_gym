package gym.workout.api.validadores;

import gym.workout.api.dto.DadosAgendamentoTreino;
import gym.workout.api.repositories.AgendamentoRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ValidacaoDiaFuturo implements Validadores{

    @Override
    public void validar(DadosAgendamentoTreino dados, AgendamentoRepository agendamentoRepository) {

        LocalDateTime now = LocalDateTime.now();
        if (dados.data().isBefore(now)) {
            throw new ValidacaoException("Você tem que marcar em uma data futura!");
        }

    }
}
