package gym.workout.api.controllers;

import gym.workout.api.models.Cliente;
import gym.workout.api.models.Treino;
import gym.workout.api.repositories.ClienteRepository;
import gym.workout.api.validadores.MontadorTreinos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculos")
public class AcademiaController {

    @Autowired
    private MontadorTreinos montadorTreinos;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Treino> mostrarTreino(@PathVariable Long id) {
        Cliente cliente = clienteRepository.getReferenceById(id);
        Treino treino = montadorTreinos.montarTreino(cliente);
        return ResponseEntity.ok(treino);
    }
}
