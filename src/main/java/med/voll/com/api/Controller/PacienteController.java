package med.voll.com.api.Controller;

import jakarta.validation.Valid;
import med.voll.com.api.Paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
	@Autowired
	private PacienteRepository repository;

	@Transactional
	@PostMapping
	public ResponseEntity cadastrar(@RequestBody DadosCadastro dados, UriComponentsBuilder uriBuilder) {
		var paciente = new Paciente(dados);
		repository.save(paciente);

		var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();

		return ResponseEntity.created(uri).body(new DadosDetalhamento(paciente));
		
	}

	@GetMapping
	public ResponseEntity<Page<DadosListagemPaciente>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
		var page = repository.findByAtivoTrue(pageable).map(DadosListagemPaciente::new);
		return ResponseEntity.ok(page);
	}

	@PutMapping
	@Transactional
	public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados){
		var paciente = repository.getReferenceById(dados.id());
		paciente.atualizaInformacoes(dados);

		return ResponseEntity.ok(new DadosDetalhamento(paciente));
	};

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity excluir(@PathVariable Long id){
		var paciente = repository.getReferenceById(id);
		paciente.excluir(id);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity detalhar(@PathVariable Long id){
		var paciente = repository.getReferenceById(id);

		return ResponseEntity.ok(new DadosDetalhamento(paciente));
	}
}





