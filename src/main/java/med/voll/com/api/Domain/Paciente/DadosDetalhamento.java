package med.voll.com.api.Domain.Paciente;

import med.voll.com.api.Domain.Endereco.Endereco;

public record DadosDetalhamento(Long id, String nome, String email, String cpf, String telefone, Endereco endereco) {
    public DadosDetalhamento(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco());
    }

}
