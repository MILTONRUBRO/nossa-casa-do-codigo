package br.com.devmos.apicdc.model;

import javax.validation.constraints.NotBlank;

public class NovoAutorForm {
	
	@NotBlank
	private String nome;
	private String descricao;
	private String email;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
