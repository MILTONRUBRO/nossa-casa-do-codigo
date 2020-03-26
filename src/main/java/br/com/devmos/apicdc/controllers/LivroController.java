package br.com.devmos.apicdc.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devmos.apicdc.model.Livro;
import br.com.devmos.apicdc.model.LivroForm;
import br.com.devmos.apicdc.repositories.AutorRepository;
import br.com.devmos.apicdc.repositories.CategoriaRepository;
import br.com.devmos.apicdc.repositories.LivroRepository;
import br.com.devmos.apicdc.validator.IsbnUnicoValidator;
import br.com.devmos.apicdc.validator.TituloLivroUnicoValidator;

@RestController
public class LivroController {
	
	@Autowired
	AutorRepository autorRepository;
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	LivroRepository livroRepository;
	
	@InitBinder("livroForm")
	public void init(WebDataBinder dataBinder) {
		dataBinder.addValidators(new IsbnUnicoValidator(livroRepository), new TituloLivroUnicoValidator(livroRepository));
		
	}
	
	@PostMapping(value="/api/livro")
	@Transactional
	public void novo(@Valid @RequestBody LivroForm form) {
		Livro livro = form.novoLivro(autorRepository, categoriaRepository);
		livroRepository.save(livro);
	}

}
