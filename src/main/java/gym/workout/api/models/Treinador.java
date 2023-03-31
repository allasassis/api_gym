package gym.workout.api.models;

import gym.workout.api.dto.DadosAtualizarTreinador;
import gym.workout.api.dto.DadosCadastroTreinador;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "treinadores")
@Entity(name = "Treinador")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Treinador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Especializacao especializacao;

    public Treinador(DadosCadastroTreinador cadastroTreinador) {
        this.nome = cadastroTreinador.nome();
        this.email = cadastroTreinador.email();
        this.telefone = cadastroTreinador.telefone();
        this.especializacao = cadastroTreinador.especializacao();
    }

    public void atualizarTreinador(DadosAtualizarTreinador dadosAtualizarTreinador) {
        if (dadosAtualizarTreinador.nome() != null) {
            this.nome = dadosAtualizarTreinador.nome();
        }
        if (dadosAtualizarTreinador.email() != null) {
            this.email = dadosAtualizarTreinador.email();
        }
        if (dadosAtualizarTreinador.telefone() != null) {
            this.telefone = dadosAtualizarTreinador.telefone();
        }
        if (dadosAtualizarTreinador.especializacao() != null) {
        this.especializacao = dadosAtualizarTreinador.especializacao();
        }
    }
}
