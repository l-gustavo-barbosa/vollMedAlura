package med.voll.com.api.Domain.Medico;

import med.voll.com.api.Domain.Endereco.Endereco;

public record DadosDetalhamento (Long id, String nome, String email,String crm, String telefone, Especialidades especialidades, Endereco endereco){
    public DadosDetalhamento(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(),  medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}
