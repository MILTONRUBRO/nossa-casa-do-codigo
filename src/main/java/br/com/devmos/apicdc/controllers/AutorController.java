package br.com.devmos.apicdc.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devmos.apicdc.model.Autor;
import br.com.devmos.apicdc.model.NovoAutorForm;
import br.com.devmos.apicdc.repositories.AutorRepository;
import br.com.devmos.apicdc.validator.SemEmailDuplicadoValidator;

@RestController
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@InitBinder("novoAutorForm")
	public void init(WebDataBinder dataBinder) {
		dataBinder.addValidators(new SemEmailDuplicadoValidator(autorRepository));
	}
	
	@PostMapping(value="/api/autor")
	@Transactional
	public void novo(@Valid @RequestBody NovoAutorForm form) {
		Autor autor = form.novoAutor();
		autorRepository.save(autor);
	}

}
