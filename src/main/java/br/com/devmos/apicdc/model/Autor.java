package br.com.devmos.apicdc.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Autor {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Size(min = 10, max = 400, message = "A descrição deve ter no mínimo 10 e no máximo 400 caracteres")
	private String descricao;
	
	@NotBlank
	@Email
	@Column(unique = true)
	private String email;
	
	private LocalDateTime instateCriacao;
	
	@Deprecated
	public Autor() {
		
	}

	public Autor(@NotBlank String nome, String descricao, String email) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		instateCriacao = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "Autor [nome=" + nome + ", descricao=" + descricao + ", email=" + email + ", instateCriacao="
				+ instateCriacao + "]";
	}
	
	

}
