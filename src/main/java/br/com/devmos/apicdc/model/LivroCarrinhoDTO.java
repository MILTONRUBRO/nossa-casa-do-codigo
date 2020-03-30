package br.com.devmos.apicdc.model;

import java.math.BigDecimal;

public class LivroCarrinhoDTO {
	
	private String titulo;
	private BigDecimal preco;
	
	@Deprecated
	public LivroCarrinhoDTO() {
		
	}

	public LivroCarrinhoDTO(Livro livro) {
		this.titulo = livro.getTitulo();
		this.preco = livro.getPreco();
	}

	public String getTitulo() {
		return titulo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	@Override
	public String toString() {
		return "LivroCarrinhoDTO [titulo=" + titulo + ", preco=" + preco + "]";
	}
	
}
