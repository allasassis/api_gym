package gym.workout.api.dto;

import gym.workout.api.models.Cliente;

public record DadosListagemCliente(String nome, String email) {

   public DadosListagemCliente(Cliente cliente) {
       this(cliente.getNome(), cliente.getEmail());
   }
}
