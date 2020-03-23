package br.com.devmos.apicdc.model;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoAutorForm {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Size(min = 10, max = 400, message = "A descrição deve ter no mínimo 10 e no máximo 400 caracteres")
	private String descricao;
	
	@NotBlank
	@Email
	@Column(unique = true)
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
	
	public Autor novoAutor() {
		return new Autor(nome, descricao, email);
	}
	
	
}
