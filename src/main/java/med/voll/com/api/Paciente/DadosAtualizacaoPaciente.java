package med.voll.com.api.Paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.com.api.Endereco.DadosEndereco;

public record DadosAtualizacaoPaciente (
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco){

}
