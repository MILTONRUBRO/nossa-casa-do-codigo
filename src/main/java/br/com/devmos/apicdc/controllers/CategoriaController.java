package br.com.devmos.apicdc.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devmos.apicdc.model.Categoria;
import br.com.devmos.apicdc.model.NovaCategoriaForm;
import br.com.devmos.apicdc.repositories.CategoriaRepository;
import br.com.devmos.apicdc.validator.SemNomeDuplicadoValidator;


@RestController
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@InitBinder("novaCategoriaForm")
	public void init(WebDataBinder dataBinder) {
		dataBinder.addValidators(new SemNomeDuplicadoValidator(categoriaRepository));
	}
	
	@PostMapping(value="/api/categoria")
	@Transactional
	public void nova(@Valid @RequestBody NovaCategoriaForm form) {
		Categoria categoria = form.novaCategoria();
		categoriaRepository.save(categoria);
		
	}

}
