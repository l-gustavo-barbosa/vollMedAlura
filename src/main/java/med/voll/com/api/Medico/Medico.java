package med.voll.com.api.Medico;

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
import med.voll.com.api.Endereco.Endereco;

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
	private String crm;
	@Enumerated(EnumType.STRING)
	private Especialidades especialidade;
	@Embedded
	private Endereco endereco;
	
	
	public Medico(DadosCadastro dados) {
		this.id = null;
		this.nome = dados.nome();
		this.crm = dados.crm();
		this.email = dados.email();
		this.especialidade = dados.especialidade();
		this.endereco = new Endereco(dados.endereco());
		
	}

}