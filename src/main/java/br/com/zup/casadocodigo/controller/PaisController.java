package br.com.zup.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.model.Pais;
import br.com.zup.casadocodigo.request.PaisRequest;

@RestController
@RequestMapping("/pais")
public class PaisController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	@Transactional
	public String salvar(@RequestBody @Valid PaisRequest request) {
		Pais pais = new Pais(request.getNome());
		manager.persist(pais);
		return pais.toString();
	}

}
