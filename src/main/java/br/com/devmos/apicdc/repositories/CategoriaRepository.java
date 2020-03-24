package br.com.devmos.apicdc.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.devmos.apicdc.model.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long>{
	
	Optional<Categoria> findByNome(String nome);

}
