package br.com.dca.condominio.service;

import br.com.dca.condominio.model.entity.Condominio;
import br.com.dca.condominio.model.entity.Torre;
import br.com.dca.condominio.model.view.ListaTorre;

import java.util.Optional;

/**
 * Created by denis on 19/01/16.
 */
public interface TorreService {

    Optional<Torre> findById(Long torreId);

    Torre save(Torre torre);

    ListaTorre findByCondominio(Condominio condominio);

    void delete(Long torreId);

}
