package gym.workout.api.dto;

import gym.workout.api.models.Especializacao;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarTreinador(String nome, @Email String email, String telefone, Especializacao especializacao) {
}
