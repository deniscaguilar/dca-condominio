package br.com.dca.condominio.service.impl;

import br.com.dca.condominio.model.entity.Administradora;
import br.com.dca.condominio.model.repository.AdministradoraRepository;
import br.com.dca.condominio.service.AdministradoraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * Created by denis on 13/01/16.
 */
@Service
@Validated
@Transactional(rollbackFor = Exception.class)
public class AdministradoraServiceImpl implements AdministradoraService {

    private static final Logger log = LoggerFactory.getLogger(AdministradoraServiceImpl.class);

    @Autowired
    private AdministradoraRepository administradoraRepository;

    @Override
    public Administradora save(Administradora administradora) {
        if(log.isDebugEnabled()){
            log.debug("Gravando administradora: {}", administradora);
        }
        return administradoraRepository.saveAndFlush(administradora);
    }

}
