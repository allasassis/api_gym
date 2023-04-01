package gym.workout.api.dto;

import gym.workout.api.models.Agendamento;

import java.time.LocalDateTime;

public record DadosDetalhamentoAgendamento(String Cliente, String Treinador, LocalDateTime DataHora) {
    public DadosDetalhamentoAgendamento(Agendamento agendamento) {
        this(agendamento.getCliente().getNome(), agendamento.getTreinador().getNome(), agendamento.getDataHora());
    }
}
