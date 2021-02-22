package br.com.zup.casadocodigo.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.casadocodigo.model.Autor;
import br.com.zup.casadocodigo.validacao.UniqueValue;

public class NovoAutorRequest {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Email
	@UniqueValue(domainClass = Autor.class, fieldName = "email", message = "Este email já está cadastrado!")
	private String email;
	
	@NotBlank
	@Size(max = 400)
	private String descricao;
	  	
	public NovoAutorRequest(@NotBlank String nome, @NotBlank @Email String email,
			@NotBlank @Size(max = 400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
	

	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}


}
