package br.com.devmos.apicdc.model;

public class LivroToHome {

	private Long id;
	private String titulo;

	public LivroToHome(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

}
