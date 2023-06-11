package med.voll.com.api.Controller;


import jakarta.validation.Valid;
import med.voll.com.api.Domain.Medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medicos")
public class MedicoController {
	
	@Autowired
	private MedicoRepository repository;

	@Transactional
	@PostMapping
	public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastro dados, UriComponentsBuilder uriBuilder) {
		var medico = new Medico(dados);
		repository.save(medico);

		var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
		return ResponseEntity.created(uri).body(new DadosDetalhamento(medico));
		
	}

	@GetMapping
	public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
		 var page = repository.findByAtivoTrue(pageable).map(DadosListagemMedico::new);
		 return ResponseEntity.ok(page);
	}

	@PutMapping
	@Transactional
	public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
		var medico = repository.getReferenceById(dados.id());
		medico.atualizaInformacoes(dados);

		return ResponseEntity.ok(new DadosDetalhamento(medico));
	};

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity excluir(@PathVariable Long id){
		var medico = repository.getReferenceById(id);
		medico.excluir(id);

		return ResponseEntity.noContent().build();
	};

	@GetMapping("/{id}")
	public ResponseEntity detalhar(@PathVariable Long id){
		var medico = repository.getReferenceById(id);

		return ResponseEntity.ok(new DadosDetalhamento(medico));
	};

}





