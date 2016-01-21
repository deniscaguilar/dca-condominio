package br.com.dca.condominio.service;

import br.com.dca.condominio.model.entity.Apartamento;
import br.com.dca.condominio.model.entity.Torre;

import java.util.List;
import java.util.Optional;

/**
 * Created by denis on 19/01/16.
 */
public interface ApartamentoService {

    Optional<Apartamento> findById(Long apartamentoId);

    Apartamento save(Apartamento apartamento);

    Optional<List<Apartamento>> findByTorre(Torre torre);

    void delete(Long apartamentoId);

}
