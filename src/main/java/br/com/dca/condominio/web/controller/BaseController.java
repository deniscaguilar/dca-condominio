package br.com.dca.condominio.web.controller;

import br.com.dca.condominio.exception.InvalidRequestException;
import org.springframework.validation.BindingResult;

/**
 * Created by denis on 04/01/16.
 */
public class BaseController {

    protected static final int ITENS_POR_PAGINA = 10;

    protected void validate(BindingResult result) {
        if (result.hasErrors()) {
            throw new InvalidRequestException("Invalid Request", result);
        }
    }

}
