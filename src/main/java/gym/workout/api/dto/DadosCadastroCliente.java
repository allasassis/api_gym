package gym.workout.api.dto;

import gym.workout.api.models.Sedentarismo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCliente(@NotNull String nome, @Email @NotNull String email, @NotNull Double altura, @NotNull Double peso, @NotNull Sedentarismo sedentarismo) {
}
