package br.com.devmos.apicdc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Carrinho {
	
	private List<LivroCarrinhoDTO> livros = new ArrayList<>();
	
	@Deprecated
	public Carrinho() {
		
	}

	public void adiciona(Livro livro) {
		livros.add(new LivroCarrinhoDTO(livro));
	}
	
	public static Carrinho create(Optional<String> jsonCarrinho) {
		return jsonCarrinho.map(json -> {
			try {
				return new ObjectMapper().readValue(json, Carrinho.class);
			} catch (JsonProcessingException e) {
				throw new RuntimeException(e);
			}
			}).orElse(new Carrinho());
	}

	@Override
	public String toString() {
		return "Carrinho [livros=" + livros + "]";
	}

	public List<LivroCarrinhoDTO> getLivros() {
		return livros;
	}
	
	

}
