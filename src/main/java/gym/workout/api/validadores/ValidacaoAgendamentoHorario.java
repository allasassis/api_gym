package gym.workout.api.validadores;

import gym.workout.api.dto.DadosAgendamentoTreino;
import gym.workout.api.repositories.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoAgendamentoHorario implements Validadores{

    public void validar(DadosAgendamentoTreino dados, AgendamentoRepository agendamentoRepository) {

        if(agendamentoRepository.existsByTreinadorIdAndDataHora(dados.idTreinador(), dados.data())) {
            throw new ValidacaoException("Treinador já tem outro agendamento nessa data! Escolha outro horário ou dia!");
        }

        if (agendamentoRepository.existsByClienteIdAndDataHora(dados.idCliente(), dados.data())) {
            throw new ValidacaoException("Cliente já tem outro agendamento nessa data! Escolha outro horário ou dia!");
        }
    }
}
