package fr.univbrest.dosi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EntitéeInvalideException extends RuntimeException {

	public EntitéeInvalideException() {
		super("L'entité à persister est invalide!");
	}
}
