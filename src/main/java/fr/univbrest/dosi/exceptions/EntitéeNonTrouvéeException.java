package fr.univbrest.dosi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntitéeNonTrouvéeException extends RuntimeException {

	private static final long serialVersionUID = -7344190446676818466L;

	public EntitéeNonTrouvéeException(String message) {
		super(message);
	}
}
