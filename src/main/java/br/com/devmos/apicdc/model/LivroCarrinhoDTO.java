package br.com.devmos.apicdc.model;

import java.math.BigDecimal;

import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LivroCarrinhoDTO {
	
	private String titulo;
	private BigDecimal preco;
	private int quantidade = 1;
	
	@Deprecated
	public LivroCarrinhoDTO() {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LivroCarrinhoDTO other = (LivroCarrinhoDTO) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
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
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public BigDecimal getTotal() {
		return preco.multiply(new BigDecimal(quantidade));
	}

	@Override
	public String toString() {
		return "LivroCarrinhoDTO [titulo=" + titulo + ", preco=" + preco + "]";
	}

	public void incrementar() {
		this.quantidade ++;
	}

	public void atualizaQuantidade(@Positive int novaQuantidade) {
		this.quantidade = novaQuantidade;
	}
	
}
