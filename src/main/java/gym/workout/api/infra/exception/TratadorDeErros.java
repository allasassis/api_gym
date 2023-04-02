package gym.workout.api.infra.exception;

import gym.workout.api.validadores.ValidacaoException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException e) {
        List<FieldError> erros = e.getFieldErrors();
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity tratarErroValidacao(ValidacaoException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }


}
