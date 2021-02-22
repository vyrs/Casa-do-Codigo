package br.com.zup.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.model.Categoria;
import br.com.zup.casadocodigo.request.NovaCategoriaRequest;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	@Transactional
	public String salvar(@RequestBody @Valid NovaCategoriaRequest request) {
		Categoria categoria = new Categoria(request.getNome());
		manager.persist(categoria);
		return categoria.toString();
	}
}
