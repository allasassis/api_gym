package gym.workout.api.validadores;

import gym.workout.api.dto.DadosAgendamentoTreino;
import gym.workout.api.repositories.AgendamentoRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ValidacaoHorario implements Validadores{
    @Override
    public void validar(DadosAgendamentoTreino dados, AgendamentoRepository agendamentoRepository) {

        LocalDateTime primeiroHorario = dados.data().withHour(6);
        LocalDateTime ultimoHorario = dados.data().withHour(22);

            if (agendamentoRepository.existsByClienteIdAndDataHoraBetween(dados.idCliente(), primeiroHorario, ultimoHorario)) {
                throw new ValidacaoException("Cliente já tem um agendamento nesse dia, escolha outro dia!");
            }
    }
}
