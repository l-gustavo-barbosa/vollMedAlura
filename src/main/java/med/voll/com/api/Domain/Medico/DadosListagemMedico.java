package med.voll.com.api.Domain.Medico;

public record DadosListagemMedico(Long id, String nome, String email, String crm, Especialidades especialidades){
    public DadosListagemMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}
