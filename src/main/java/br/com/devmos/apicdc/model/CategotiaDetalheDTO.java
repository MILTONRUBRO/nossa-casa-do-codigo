package br.com.devmos.apicdc.model;

import javax.validation.constraints.NotNull;

public class CategotiaDetalheDTO {

	private String nome;

	public CategotiaDetalheDTO( Categoria categoria) {
		
		this.nome = categoria.getNome();
	}

	public String getNome() {
		return nome;
	}
	
}
