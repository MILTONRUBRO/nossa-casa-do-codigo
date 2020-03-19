package br.com.devmos.apicdc.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devmos.apicdc.model.NovoAutorForm;

@RestController
public class AutorController {
	
	@PostMapping(value="/api/autor")
	public void novo(@Valid NovoAutorForm form) {
		System.out.println("teste ");
	}

}
