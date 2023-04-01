package gym.workout.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoTreino(@NotNull Long idCliente, @NotNull Long idTreinador, @NotNull @Future @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                     LocalDateTime data) {
}
