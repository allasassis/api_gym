package gym.workout.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Treino {

    @Enumerated(EnumType.STRING)
    private List<Exercicios> exerciciosList = new ArrayList<>();

}
