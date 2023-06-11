package med.voll.com.api.Domain.Medico;


import jakarta.validation.constraints.NotNull;
import med.voll.com.api.Domain.Endereco.DadosEndereco;

public record DadosAtualizacaoMedico(        @NotNull
                                             Long id,
                                             String nome,
                                             String telefone,
                                             DadosEndereco endereco) {


}


