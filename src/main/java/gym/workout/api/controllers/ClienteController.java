package gym.workout.api.controllers;

import gym.workout.api.dto.DadosCadastroCliente;
import gym.workout.api.dto.DadosDetalhamentoCliente;
import gym.workout.api.dto.DadosListagemCliente;
import gym.workout.api.models.Cliente;
import gym.workout.api.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

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
}
