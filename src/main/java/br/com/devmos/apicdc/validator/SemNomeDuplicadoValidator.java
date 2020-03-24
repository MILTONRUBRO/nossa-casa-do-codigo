package br.com.devmos.apicdc.validator;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.devmos.apicdc.model.Categoria;
import br.com.devmos.apicdc.model.NovaCategoriaForm;
import br.com.devmos.apicdc.repositories.CategoriaRepository;

public class SemNomeDuplicadoValidator implements Validator {
	
	private CategoriaRepository categoriaRepository;
	
	public SemNomeDuplicadoValidator(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return NovaCategoriaForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NovaCategoriaForm form = (NovaCategoriaForm) target;
		Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(form.getNome());
		
		if(possivelCategoria.isPresent()) {
			errors.rejectValue("nome", null, "Está categoria já foi cadastrada.");
		}

	}

}
