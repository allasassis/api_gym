package gym.workout.api.dto;

import gym.workout.api.models.Especializacao;
import gym.workout.api.models.Treinador;

public record DadosListagemTreinador(String nome, Especializacao especializacao) {
    public DadosListagemTreinador(Treinador treinador) {
        this(treinador.getNome(), treinador.getEspecializacao());
    }
}
