package gym.workout.api.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAutenticacao(@NotNull String login, @NotNull String password) {
}
