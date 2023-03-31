package gym.workout.api.controllers;

import com.electronwill.nightconfig.core.conversion.Path;
import gym.workout.api.dto.DadosAtualizarTreinador;
import gym.workout.api.dto.DadosCadastroTreinador;
import gym.workout.api.dto.DadosDetalhamentoTreinador;
import gym.workout.api.dto.DadosListagemTreinador;
import gym.workout.api.models.Treinador;
import gym.workout.api.repositories.TreinadorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoTreinador> cadastrarTreinador(@RequestBody DadosCadastroTreinador cadastroTreinador, UriComponentsBuilder uriComponentsBuilder) {
        Treinador treinador = new Treinador(cadastroTreinador);
        repository.save(treinador);
        URI uri = uriComponentsBuilder.path("/treinadores/{id}").buildAndExpand(treinador.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTreinador(treinador));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTreinador> atualizarTreinador(@RequestBody DadosAtualizarTreinador atualizacaoTreinador, @PathVariable Long id) {
        Treinador treinador = repository.getReferenceById(id);
        treinador.atualizarTreinador(atualizacaoTreinador);
        repository.save(treinador);
        return ResponseEntity.ok(new DadosDetalhamentoTreinador(treinador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarTreinador(@PathVariable Long id) {
        Optional<Treinador> treinador = repository.findById(id);
        if (treinador.isPresent()) {
            repository.deleteById(id);
        }
        return ResponseEntity.noContent().build();
    }

}
