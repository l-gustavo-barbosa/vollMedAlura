package med.voll.com.api.Paciente;

import med.voll.com.api.Endereco.DadosEndereco;

public record DadosCadastro(String nome, String email, String telefone, String cpf, DadosEndereco endereco) {

}
