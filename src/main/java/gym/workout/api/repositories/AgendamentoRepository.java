package gym.workout.api.repositories;

import gym.workout.api.dto.DadosAgendamentoTreino;
import gym.workout.api.models.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    boolean existsByTreinadorIdAndDataHora(Long treinadorId, LocalDateTime dataHora);

    boolean existsByClienteIdAndDataHora(Long clienteId, LocalDateTime dataHora);
}
