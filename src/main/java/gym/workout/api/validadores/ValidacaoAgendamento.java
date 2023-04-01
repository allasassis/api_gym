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

@Service
public class ValidacaoAgendamento {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TreinadorRepository treinadorRepository;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public Agendamento agendar(DadosAgendamentoTreino dados) {
        ValidacaoAgendamentoHorario validacaoAgendamentoHorario = new ValidacaoAgendamentoHorario();
        validacaoAgendamentoHorario.validar(dados, agendamentoRepository);

        Cliente cliente = clienteRepository.getReferenceById(dados.idCliente());
        Treinador treinador = treinadorRepository.getReferenceById(dados.idTreinador());
        Agendamento agendamento = new Agendamento(dados.data(), treinador, cliente);
        agendamentoRepository.save(agendamento);
        return agendamento;
    }
}
