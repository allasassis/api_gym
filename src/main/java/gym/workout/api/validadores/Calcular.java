package gym.workout.api.validadores;

import gym.workout.api.models.IMC;
import org.springframework.stereotype.Component;

@Component
public class Calcular {

    private IMC imc;

    public static IMC imc(Double peso, Double altura) {

        double IMC = peso / (altura * altura);

        if (IMC < 18.5) {
            return gym.workout.api.models.IMC.ABAIXO_DO_PESO_NORMAL;
        }
        if (IMC > 18.5 && IMC < 24.9) {
            return gym.workout.api.models.IMC.PESO_NORMAL;
        }
        if (IMC > 25.9 && IMC < 29.9) {
            return gym.workout.api.models.IMC.EXCESSO_DE_PESO;
        }
        if (IMC > 30.0 && IMC < 34.9) {
            return gym.workout.api.models.IMC.OBESIDADE_I;
        }
        if (IMC > 35.0 && IMC < 39.9) {
            return gym.workout.api.models.IMC.OBESIDADE_II;
        }
        else {
            return gym.workout.api.models.IMC.OBESIDADE_III;
        }
    }
}
