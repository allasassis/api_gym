package gym.workout.api.dto;

import gym.workout.api.models.Cliente;
import gym.workout.api.models.Sedentarismo;

public record DadosDetalhamentoCliente(String nome, String email, Double altura, Double peso, Sedentarismo sedentarismo) {
    public DadosDetalhamentoCliente(Cliente cliente) {
        this(cliente.getNome(), cliente.getEmail(), cliente.getAltura(), cliente.getPeso(), cliente.getSedentarismo());
    }
}
