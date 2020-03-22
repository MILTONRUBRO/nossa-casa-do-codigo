package br.com.devmos.apicdc.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devmos.apicdc.model.Autor;
import br.com.devmos.apicdc.model.NovoAutorForm;

@RestController
public class AutorController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping(value="/api/autor")
	@Transactional
	public void novo(@Valid @RequestBody NovoAutorForm form) {
		Autor autor = form.novoAutor();
		
		manager.persist(autor);
		
	}

}
