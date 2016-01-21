package br.com.dca.condominio.service;

import br.com.dca.condominio.model.entity.Condominio;
import br.com.dca.condominio.model.view.ListaCondominio;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Created by denis on 04/01/16.
 */
public interface CondominioService {

    Optional<Condominio> findById(Long condominioId);

    Condominio save(Condominio condominio);

    ListaCondominio findByPage(Pageable page);

    void delete(Long condominioId);

}
