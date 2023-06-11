package med.voll.com.api.Infra.Exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity erro404(){

        return ResponseEntity.notFound().build();
    };

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity erro400(MethodArgumentNotValidException e){
        var erros = e.getFieldErrors();


        return ResponseEntity.badRequest().body(erros.stream().map(DadosErro400::new).toList());
    };

    private record DadosErro400(String campo, String mensagem){
        public DadosErro400(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    };

}
