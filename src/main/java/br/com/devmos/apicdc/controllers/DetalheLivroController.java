package br.com.devmos.apicdc.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.devmos.apicdc.errors.ResourceNotFoundException;
import br.com.devmos.apicdc.model.Carrinho;
import br.com.devmos.apicdc.model.Cookies;
import br.com.devmos.apicdc.model.Livro;
import br.com.devmos.apicdc.model.LivroDetalheDTO;
import br.com.devmos.apicdc.repositories.LivroRepository;

@RestController
public class DetalheLivroController {
	
	@Autowired
	private LivroRepository LivroRepository;
	
	@Autowired
	private Cookies cookies;
	
	@GetMapping(value="/api/livro/{id}")
	public  LivroDetalheDTO getDetalhelivro(@PathVariable("id") Long id){
		Livro livro = LivroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		return  new LivroDetalheDTO(livro);
	}
	
	@PostMapping(value="/api/carrinho/{idLivro}")
	public String addLivroCarrinho(@PathVariable("idLivro") Long idLivro, @CookieValue("carrinho") Optional<String> jsonCarrinho, HttpServletResponse response) throws JsonProcessingException {
		
		Carrinho carrinho = Carrinho.create(jsonCarrinho);
		carrinho.adiciona(LivroRepository.findById(idLivro).get());
		
		cookies.writeAsJson("carrinho", carrinho, response);
		
		return carrinho.toString();
	}

}
