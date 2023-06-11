package med.voll.com.api.Medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.com.api.Endereco.DadosEndereco;

public record DadosCadastro(
       @NotBlank
        String nome,
       @NotBlank @Email
        String email,
       @NotBlank
       String telefone,
       @NotBlank @Pattern(regexp="\\d{4,6}")
        String crm,
       @NotNull
        Especialidades especialidade,
       @NotNull @Valid
        DadosEndereco endereco) {

}
