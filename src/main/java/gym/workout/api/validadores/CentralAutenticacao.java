package gym.workout.api.validadores;

import gym.workout.api.dto.DadosAutenticacao;
import gym.workout.api.infra.security.Usuario;
import gym.workout.api.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CentralAutenticacao {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void validarECriptografar(DadosAutenticacao dadosAutenticacao) {
        UserDetails login = usuarioRepository.findByLogin(dadosAutenticacao.login());
        if (login != null) {
            throw new ValidacaoException("Login já existe! Escolha outro nome de usuário, por favor!");
        }

        String password = passwordEncoder.encode(dadosAutenticacao.password());
        Usuario usuario = new Usuario(dadosAutenticacao.login(), password);
        usuarioRepository.save(usuario);
    }
}
