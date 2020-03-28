package br.com.devmos.apicdc.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	private String titulo;

	@NotBlank
	@Size(min = 10, max = 500, message = "O resumo do livro deve ter no mínimo 10 e no máximo 500 caracteres")
	private String resumo;
	
	
	private String sumario;

	@Min(20)
	private BigDecimal preco;

	@Min(100)
	private int numeroPaginas;

	@NotBlank
	private String isbn;

	private LocalDateTime dataPublicacao;
	
	 @NotNull
	 @ManyToOne
	 Autor autor;
	 
	 @NotNull
	 @ManyToOne
	 Categoria categoria;
	 
	 @Deprecated
	 public Livro() {
		 
	 }

	public Livro(@NotBlank String titulo,
			@NotBlank @Size(min = 10, max = 500, message = "O resumo do livro deve ter no mínimo 10 e no máximo 500 caracteres") String resumo,
			String sumario, @Min(20) BigDecimal preco, @Min(100) int numeroPaginas, @NotBlank String isbn,
			LocalDateTime dataPublicacao, @NotNull Autor autor, @NotNull Categoria categoria) {
		
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.autor = autor;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	

}
