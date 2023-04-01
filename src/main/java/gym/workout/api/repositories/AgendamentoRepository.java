package gym.workout.api.repositories;

import gym.workout.api.models.Agendamento;
import gym.workout.api.models.Treinador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {


}
