package med.voll.com.api.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.com.api.Paciente.DadosCadastro;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
	
	@PostMapping
	public void cadastrar(@RequestBody DadosCadastro dados) {
		System.out.println("Dados recebidos: " + dados);;
		
	}
}





