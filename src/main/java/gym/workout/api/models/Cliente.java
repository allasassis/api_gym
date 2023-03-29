package gym.workout.api.models;

import gym.workout.api.dto.DadosCadastroCliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "clientes")
@Entity(name = "Cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private Double altura;
    private Double peso;

    @Enumerated(EnumType.STRING)
    private Sedentarismo sedentarismo;

    public Cliente(DadosCadastroCliente dadosCadastroCliente) {
        this.nome = dadosCadastroCliente.nome();
        this.email = dadosCadastroCliente.email();
        this.altura = dadosCadastroCliente.altura();
        this.peso = dadosCadastroCliente.peso();
        this.sedentarismo = dadosCadastroCliente.sedentarismo();
    }
}
