package br.com.devmos.apicdc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.devmos.apicdc.errors.ResourceNotFoundException;
import br.com.devmos.apicdc.model.Livro;
import br.com.devmos.apicdc.model.LivroDetalheDTO;
import br.com.devmos.apicdc.repositories.LivroRepository;
import javassist.NotFoundException;

@RestController
public class DetalheLivroController {
	
	@Autowired
	private LivroRepository LivroRepository;
	
	@GetMapping(value="/api/livro/{id}")
	public  LivroDetalheDTO getDetalhelivro(@PathVariable Long id){
		Livro livro = LivroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		return  new LivroDetalheDTO(livro);
	}

}
