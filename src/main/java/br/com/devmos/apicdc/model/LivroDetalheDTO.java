package br.com.devmos.apicdc.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LivroDetalheDTO {
	
	private Long id;
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private int numeroPaginas;
	private String isbn;
	private LocalDateTime dataPublicacao;
	private AutorLivroDetalheDTO autor;
	private CategotiaDetalheDTO categoria;

	public LivroDetalheDTO(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario= livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao();
		this.autor = new AutorLivroDetalheDTO(livro.getAutor());
		this.categoria = new CategotiaDetalheDTO(livro.categoria);
		
	}
	
	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDateTime getDataPublicacao() {
		return dataPublicacao;
	}

	public AutorLivroDetalheDTO getAutor() {
		return autor;
	}

	public CategotiaDetalheDTO getCategoria() {
		return categoria;
	}
	
}
