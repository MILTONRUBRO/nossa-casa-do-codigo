package br.com.devmos.apicdc.validator;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.devmos.apicdc.model.Livro;
import br.com.devmos.apicdc.model.LivroForm;
import br.com.devmos.apicdc.repositories.LivroRepository;

public class IsbnUnicoValidator implements Validator {
	
	LivroRepository livroRepository;

	public IsbnUnicoValidator(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return LivroForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		LivroForm form = (LivroForm) target;
		Optional<Livro> possivelLivro = livroRepository.findByIsbn(form.getIsbn());
		
		if(possivelLivro.isPresent()) {
			errors.rejectValue("isbn", null, "Um livro com este isbn já está cadastrado.");
		}
	}

}
