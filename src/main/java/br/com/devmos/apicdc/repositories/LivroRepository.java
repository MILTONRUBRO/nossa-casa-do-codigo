package br.com.devmos.apicdc.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.devmos.apicdc.model.Livro;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long>{

	Optional<Livro> findByTitulo(String titulo);

	Optional<Livro> findByIsbn(String isbn);
	

}
