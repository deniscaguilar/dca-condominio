package br.com.dca.condominio.service;

import br.com.dca.condominio.model.entity.TipoProfissional;
import br.com.dca.condominio.model.view.ListaTipoProfissional;

import java.util.Optional;

/**
 * Created by denis on 13/01/16.
 */
public interface TipoProfissionalService {

    Optional<TipoProfissional> findById(Long tipoProfissionalId);

    ListaTipoProfissional findAll();
}
