package br.com.dca.condominio.service;

import br.com.dca.condominio.model.entity.AreaComum;
import br.com.dca.condominio.model.entity.Condominio;

import java.util.List;
import java.util.Optional;

/**
 * Created by denis on 19/01/16.
 */
public interface AreaComumService {

    Optional<AreaComum> findById(Long areaComumId);

    AreaComum save(AreaComum areaComum);

    Optional<List<AreaComum>> findByCondominio(Condominio condominio);

    void delete(Long areaComumId);

}
