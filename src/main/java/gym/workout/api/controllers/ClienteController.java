package gym.workout.api.controllers;

import gym.workout.api.dto.DadosAtualizacaoCliente;
import gym.workout.api.dto.DadosCadastroCliente;
import gym.workout.api.dto.DadosDetalhamentoCliente;
import gym.workout.api.dto.DadosListagemCliente;
import gym.workout.api.models.Cliente;
import gym.workout.api.models.Treino;
import gym.workout.api.repositories.ClienteRepository;
import gym.workout.api.validadores.MontadorTreinos;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@SecurityRequirement(name = "bearer-key")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MontadorTreinos montadorTreinos;

    @GetMapping
    public ResponseEntity<List<DadosListagemCliente>> listarClientes() {
        List<DadosListagemCliente> clientes = clienteRepository.findAll().stream().map(DadosListagemCliente::new).toList();
        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoCliente> cadastrarCliente(@RequestBody DadosCadastroCliente dadosCadastroCliente, UriComponentsBuilder uriB) {
        Cliente cliente = new Cliente(dadosCadastroCliente);
        clienteRepository.save(cliente);
        URI uri = uriB.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoCliente(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarCliente(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);

        cliente.ifPresent(cliente1 -> clienteRepository.delete(cliente1));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarCliente(@RequestBody DadosAtualizacaoCliente dadosAtualizacaoCliente, @PathVariable Long id) {
        Cliente cliente = clienteRepository.getReferenceById(id);
        cliente.atualizarCliente(dadosAtualizacaoCliente);

        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }

    @GetMapping("/treino/{id}")
    public ResponseEntity<Treino> mostrarTreino(@PathVariable Long id) {
        Cliente cliente = clienteRepository.getReferenceById(id);
        Treino treino = montadorTreinos.montarTreino(cliente);
        return ResponseEntity.ok(treino);
    }
}
