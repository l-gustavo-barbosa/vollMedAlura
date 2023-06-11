package med.voll.com.api.Domain.Medico;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.com.api.Domain.Endereco.Endereco;

@Table(name = "medicos")
@Entity(name = "medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String crm;
	@Enumerated(EnumType.STRING)
	private Especialidades especialidade;
	@Embedded
	private Endereco endereco;
	private Boolean ativo;
	
	
	public Medico(DadosCadastro dados) {
		this.ativo = true;
		this.id = null;
		this.nome = dados.nome();
		this.crm = dados.crm();
		this.email = dados.email();
		this.telefone = dados.telefone();
		this.especialidade = dados.especialidade();
		this.endereco = new Endereco(dados.endereco());
		
	}

    public void atualizaInformacoes(DadosAtualizacaoMedico dados) {
		if (dados.nome() != null){
			this.nome = dados.nome();
		}
		if (dados.endereco() != null){
			this.endereco.atualiza(dados.endereco());
		}
		if (dados.telefone() != null){
			this.telefone = dados.telefone();
		}
    }

	public void excluir(Long id) {
		this.ativo = false;
	}
}
