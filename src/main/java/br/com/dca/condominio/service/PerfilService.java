package br.com.dca.condominio.service;

import br.com.dca.condominio.model.entity.Perfil;
import br.com.dca.condominio.model.view.ListaPerfil;

import java.util.Optional;

/**
 * Created by denis on 13/01/16.
 */
public interface PerfilService {

    Optional<Perfil> findById(Long perfilId);

    Perfil save(Perfil perfil);

    ListaPerfil findAll();

    void delete(Long perfilId);

}
