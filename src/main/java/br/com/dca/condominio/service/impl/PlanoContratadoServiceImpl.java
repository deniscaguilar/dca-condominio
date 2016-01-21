package br.com.dca.condominio.service.impl;

import br.com.dca.condominio.model.entity.PlanoContratado;
import br.com.dca.condominio.model.repository.PlanoContratadoRepository;
import br.com.dca.condominio.service.PlanoContratadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by denis on 13/01/16.
 */
@Service
@Validated
@Transactional(rollbackFor = Exception.class)
public class PlanoContratadoServiceImpl implements PlanoContratadoService {

    private static final Logger log = LoggerFactory.getLogger(PerfilServiceImpl.class);

    @Autowired
    private PlanoContratadoRepository planoContratadoRepository;

    @Override
    public PlanoContratado save(@NotNull @Valid PlanoContratado planoContratado) {
        if(log.isDebugEnabled()){
            log.debug("Gravando Plano Contratado: {}", planoContratado);
        }
        return planoContratadoRepository.saveAndFlush(planoContratado);
    }

}
