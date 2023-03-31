package gym.workout.api.validadores;

import gym.workout.api.models.Cliente;
import gym.workout.api.models.Exercicios;
import gym.workout.api.models.IMC;
import gym.workout.api.models.Treino;
import org.springframework.stereotype.Service;

@Service
public class MontadorTreinos {

    public Treino montarTreino(Cliente cliente) {
        IMC imc = Calcular.imc(cliente.getPeso(), cliente.getAltura());
        return especializado(imc);
    }

    private Treino especializado(IMC imc) {
        Treino treino = new Treino();
        if (imc == IMC.ABAIXO_DO_PESO_NORMAL || imc == IMC.PESO_NORMAL) {
            treino.getExerciciosList().add(Exercicios.AGACHAMENTO_LIVRE);
            treino.getExerciciosList().add(Exercicios.PULLEY_FRENTE);
            treino.getExerciciosList().add(Exercicios.CROSSOVER);
            treino.getExerciciosList().add(Exercicios.LEG_PRESS);
            treino.getExerciciosList().add(Exercicios.ABDOMINAL);
            treino.getExerciciosList().add(Exercicios.CORRER_DEZ_MIN);
        }
        if (imc == IMC.EXCESSO_DE_PESO || imc == IMC.OBESIDADE_I) {
            treino.getExerciciosList().add(Exercicios.PULLEY_FRENTE);
            treino.getExerciciosList().add(Exercicios.CROSSOVER);
            treino.getExerciciosList().add(Exercicios.LEG_PRESS);
            treino.getExerciciosList().add(Exercicios.CROSSOVER_SENTADO);
            treino.getExerciciosList().add(Exercicios.CORRER_VINTE_MIN);
        }
        if (imc == IMC.OBESIDADE_II || imc == IMC.OBESIDADE_III) {
            treino.getExerciciosList().add(Exercicios.PULLEY_COSTAS);
            treino.getExerciciosList().add(Exercicios.PULLEY_FRENTE);
            treino.getExerciciosList().add(Exercicios.CROSSOVER);
            treino.getExerciciosList().add(Exercicios.LEG_PRESS);
            treino.getExerciciosList().add(Exercicios.AGACHAMENTO_LIVRE);
            treino.getExerciciosList().add(Exercicios.CROSSOVER_SENTADO);
            treino.getExerciciosList().add(Exercicios.CORRER_TRINTA_MIN);
        }
        return treino;
    }

}
