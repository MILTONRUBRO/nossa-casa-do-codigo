package br.com.devmos.apicdc.model;

public class AutorLivroDetalheDTO{

	private String nome;
	private String descricao;

	public AutorLivroDetalheDTO(Autor autor) {
		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();
		
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
