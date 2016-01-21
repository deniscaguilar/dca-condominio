package br.com.dca.condominio.service;

import br.com.dca.condominio.model.entity.Condominio;
import br.com.dca.condominio.model.entity.Multa;

import java.util.List;
import java.util.Optional;

/**
 * Created by denis on 19/01/16.
 */
public interface MultaService {

    Optional<Multa> findById(Long multaId);

    Multa save(Multa multa);

    Optional<List<Multa>> findByCondominio(Condominio condominio);

    void delete(Long multaId);

}
