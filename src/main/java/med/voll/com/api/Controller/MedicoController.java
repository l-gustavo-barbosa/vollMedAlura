package med.voll.com.api.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.com.api.Medico.DadosCadastro;
import med.voll.com.api.Medico.Medico;
import med.voll.com.api.Medico.MedicoRepository;

@RestController
@RequestMapping("medicos")
public class MedicoController {
	
	private MedicoRepository repository;

	@PostMapping
	public void cadastrar(@RequestBody DadosCadastro dados) {
		repository.save(new Medico(dados));
		
	}
}





