package gym.workout.api.validadores;

import gym.workout.api.dto.DadosAgendamentoTreino;
import gym.workout.api.models.Agendamento;
import gym.workout.api.models.Cliente;
import gym.workout.api.models.Treinador;
import gym.workout.api.repositories.ClienteRepository;
import gym.workout.api.repositories.TreinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoAgendamentoHorario {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TreinadorRepository treinadorRepository;

    public void validar(DadosAgendamentoTreino dados) {
        Cliente cliente = clienteRepository.getReferenceById(dados.idCliente());
        Treinador treinador = treinadorRepository.getReferenceById(dados.idTreinador());


    }
}
