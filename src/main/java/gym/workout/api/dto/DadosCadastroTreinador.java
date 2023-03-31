package gym.workout.api.dto;

import gym.workout.api.models.Especializacao;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTreinador(@NotNull String nome, @NotNull @Email String email, @NotNull String telefone, @NotNull
                                     Especializacao especializacao) {
}
