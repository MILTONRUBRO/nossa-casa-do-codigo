package br.com.devmos.apicdc.model;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class NovaCategoriaForm {

	@NotBlank
	@Column(unique = true)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria novaCategoria() {
		return new Categoria(nome);
	}

}
