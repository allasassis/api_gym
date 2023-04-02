package gym.workout.api.controllers;

import gym.workout.api.dto.DadosAutenticacao;
import gym.workout.api.infra.security.DadosTokenJWT;
import gym.workout.api.infra.security.TokenService;
import gym.workout.api.infra.security.Usuario;
import gym.workout.api.validadores.CentralAutenticacao;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private CentralAutenticacao centralAutenticacao;

    @PostMapping
    public ResponseEntity autenticarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.password());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        String token = tokenService.gerarToken((Usuario) authenticate.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(token));
    }

    @PostMapping("/new")
    @Transactional
    public ResponseEntity efetuarCadastro(@RequestBody @Valid DadosAutenticacao dados) {
        centralAutenticacao.validarECriptografar(dados);

        return ResponseEntity.created(null).build();
    }
}
