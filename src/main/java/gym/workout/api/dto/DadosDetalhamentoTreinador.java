package gym.workout.api.dto;

import gym.workout.api.models.Especializacao;
import gym.workout.api.models.Treinador;

public record DadosDetalhamentoTreinador(String nome, Especializacao especializacao) {
    public DadosDetalhamentoTreinador(Treinador treinador) {
        this(treinador.getNome(), treinador.getEspecializacao());
    }
}
