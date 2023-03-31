package gym.workout.api.repositories;

import gym.workout.api.models.Cliente;
import gym.workout.api.models.Treinador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreinadorRepository extends JpaRepository<Treinador, Long> {

}
