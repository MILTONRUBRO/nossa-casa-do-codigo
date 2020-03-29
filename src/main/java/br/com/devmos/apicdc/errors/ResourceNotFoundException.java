package br.com.devmos.apicdc.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "livro not found")
public class ResourceNotFoundException  extends RuntimeException {

}
