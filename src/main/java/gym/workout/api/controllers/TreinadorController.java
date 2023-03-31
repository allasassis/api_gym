package gym.workout.api.controllers;

import gym.workout.api.dto.DadosCadastroTreinador;
import gym.workout.api.dto.DadosDetalhamentoTreinador;
import gym.workout.api.dto.DadosListagemTreinador;
import gym.workout.api.models.Treinador;
import gym.workout.api.repositories.TreinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/treinador")
public class TreinadorController {

    @Autowired
    private TreinadorRepository repository;

    @GetMapping
    public ResponseEntity<List<DadosListagemTreinador>> listarTreinadores() {
        List<DadosListagemTreinador> list = repository.findAll().stream().map(DadosListagemTreinador::new).toList();
        return ResponseEntity.ok(list);
    }

    @PutMapping
    public ResponseEntity<DadosDetalhamentoTreinador> cadastrarTreinador(@RequestBody DadosCadastroTreinador cadastroTreinador, UriComponentsBuilder uriComponentsBuilder) {
        Treinador treinador = new Treinador(cadastroTreinador);
        repository.save(treinador);
        URI uri = uriComponentsBuilder.path("/treinadores/{id}").buildAndExpand(treinador.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTreinador(treinador));
    }

}
