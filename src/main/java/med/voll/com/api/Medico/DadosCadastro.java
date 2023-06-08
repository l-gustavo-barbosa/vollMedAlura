package med.voll.com.api.Medico;

import med.voll.com.api.Endereco.DadosEndereco;

public record DadosCadastro(String nome, String email, String crm, Especialidades especialidade, DadosEndereco endereco) {

}
