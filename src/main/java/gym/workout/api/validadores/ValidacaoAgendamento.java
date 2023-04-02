package gym.workout.api.validadores;

import gym.workout.api.dto.DadosAgendamentoTreino;
import gym.workout.api.models.Agendamento;
import gym.workout.api.models.Cliente;
import gym.workout.api.models.Treinador;
import gym.workout.api.repositories.AgendamentoRepository;
import gym.workout.api.repositories.ClienteRepository;
import gym.workout.api.repositories.TreinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidacaoAgendamento {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TreinadorRepository treinadorRepository;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private List<Validadores> validadores;

    public Agendamento agendar(DadosAgendamentoTreino dados) {

        if (!clienteRepository.existsById(dados.idCliente())) {
            throw new ValidacaoException("ID do cliente não existe!");
        }

        if (!treinadorRepository.existsById(dados.idTreinador())) {
            throw new ValidacaoException("ID do treinador não existe!");
        }

        validadores.forEach(validadores1 -> validadores1.validar(dados, agendamentoRepository));

        Cliente cliente = clienteRepository.getReferenceById(dados.idCliente());
        Treinador treinador = treinadorRepository.getReferenceById(dados.idTreinador());
        Agendamento agendamento = new Agendamento(dados.data(), treinador, cliente);
        agendamentoRepository.save(agendamento);
        return agendamento;
    }
}
