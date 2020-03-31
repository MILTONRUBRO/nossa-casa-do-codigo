package br.com.devmos.apicdc.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Carrinho {
	
	private Set<LivroCarrinhoDTO> livros = new LinkedHashSet<>();
	
	@Deprecated
	public Carrinho() {
		
	}

	public void adiciona(Livro livro) {
		
		LivroCarrinhoDTO novoItem = new LivroCarrinhoDTO(livro);
		 boolean result = livros.add(novoItem);
		 
		 if(!result) {
			 LivroCarrinhoDTO itemExistente = livros.stream().filter(novoItem :: equals).findFirst().get();
			 itemExistente.incrementar();
		 }
		
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

	public Set<LivroCarrinhoDTO> getLivros() {
		return livros;
	}

	public void atualiza(@NotNull Livro livro, @Positive int novaQuantidade) {
		LivroCarrinhoDTO livroExistente = new LivroCarrinhoDTO(livro);
		Optional<LivroCarrinhoDTO> possiveltem = livros.stream().filter(livroExistente :: equals).findFirst();
		
		LivroCarrinhoDTO itemExistente = possiveltem.get();
		
		itemExistente.atualizaQuantidade(novaQuantidade);
		
	}
	
	public BigDecimal getTotal() {
		return livros.stream().map(item -> item.getTotal()).reduce(BigDecimal.ZERO, (atual, proximo) -> atual.add(proximo));
	}
	

}
