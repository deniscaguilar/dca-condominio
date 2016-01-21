package br.com.dca.condominio.service;

import br.com.dca.condominio.model.entity.Funcionalidade;
import br.com.dca.condominio.model.view.ListaFuncionalidade;

import java.util.Optional;

/**
 * Created by denis on 13/01/16.
 */
public interface FuncionalidadeService {

    Optional<Funcionalidade> findById(Long funcionalidadeId);

    Funcionalidade save(Funcionalidade funcionalidade);

    ListaFuncionalidade findAll();

    void delete(Long funcionalidadeId);

}
