package gym.workout.api.dto;

import gym.workout.api.models.Sedentarismo;
import jakarta.validation.constraints.Email;

public record DadosAtualizacaoCliente(String nome, @Email String email, Double altura, Double peso, Sedentarismo sedentarismo) {

}
