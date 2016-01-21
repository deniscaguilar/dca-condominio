package br.com.dca.condominio.service.impl;

import br.com.dca.condominio.model.entity.Perfil;
import br.com.dca.condominio.model.repository.PerfilRepository;
import br.com.dca.condominio.model.view.ListaPerfil;
import br.com.dca.condominio.service.PerfilService;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * Created by denis on 13/01/16.
 */
@Service
@Validated
@Transactional(rollbackFor = Exception.class)
public class PerfilServiceImpl implements PerfilService {

    private static final Logger log = LoggerFactory.getLogger(PerfilServiceImpl.class);

    @Autowired
    private PerfilRepository perfilRepository;

    @Transactional(readOnly = true)
    @Override
    public Optional<Perfil> findById(@NotNull Long perfilId) {
        Perfil perfil = perfilRepository.findOne(perfilId);
        return Optional.ofNullable(perfil);
    }

    @Override
    public Perfil save(@NotNull @Valid Perfil perfil) {
        if(log.isDebugEnabled()){
            log.debug("Gravando perfil: {}", perfil);
        }
        return perfilRepository.saveAndFlush(perfil);
    }

    @Transactional(readOnly = true)
    @Override
    public ListaPerfil findAll() {
        long count = perfilRepository.count();
        return new ListaPerfil(count, Lists.newArrayList(perfilRepository.findAll()));
    }

    @Override
    public void delete(@NotNull Long perfilId) {
        if (log.isDebugEnabled()) {
            log.debug("Removendo perfil: {}", perfilId);
        }
        perfilRepository.delete(perfilId);
    }
}
