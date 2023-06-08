package med.voll.com.api.Endereco;

import jakarta.persistence.Embeddable;


public record DadosEndereco(String logradouro, String bairro, String cep, String cidade, String uf, String complemento, String numero) {
	
}
