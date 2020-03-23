package br.com.devmos.apicdc.validator;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.devmos.apicdc.model.Autor;
import br.com.devmos.apicdc.model.NovoAutorForm;
import br.com.devmos.apicdc.repositories.AutorRepository;

public class SemEmailDuplicadoValidator implements Validator {
	
	private AutorRepository autorRepository;
	
	public SemEmailDuplicadoValidator(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return NovoAutorForm.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NovoAutorForm form = (NovoAutorForm) target;
		Optional<Autor> possivelAutor = autorRepository.findByEmail(form.getEmail());
		
		if(possivelAutor.isPresent()) {
			errors.rejectValue("email", null, "Esse e-mail já está cadastrado.");
		}

	}

}
