package br.com.devmos.apicdc.controllers;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devmos.apicdc.model.LivroToHome;
import br.com.devmos.apicdc.repositories.LivroRepository;

@RestController
public class HomeController {
	
	@Autowired
	LivroRepository livroRepository;
	
	@GetMapping(value="api/home")
	public Iterable<LivroToHome> home() {
		return livroRepository.findAll().stream().map(LivroToHome :: new).collect(Collectors.toList());
	}

}
