package br.com.dca.condominio.exception;

import org.springframework.validation.Errors;

/**
 * Created by denis on 04/01/16.
 */
@SuppressWarnings("serial")
public class InvalidRequestException extends RuntimeException {

    private Errors errors;

    public InvalidRequestException(String message, Errors errors){
        super(message);
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }
}
