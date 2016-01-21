package br.com.dca.condominio.service.impl;

import br.com.dca.condominio.model.entity.Condominio;
import br.com.dca.condominio.model.entity.Multa;
import br.com.dca.condominio.model.repository.MultaRepository;
import br.com.dca.condominio.service.MultaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

/**
 * Created by denis on 19/01/16.
 */
@Service
@Validated
@Transactional(rollbackFor = Exception.class)
public class MultaServiceImpl implements MultaService {

    private static final Logger log = LoggerFactory.getLogger(MultaServiceImpl.class);

    @Autowired
    private MultaRepository multaRepository;

    @Transactional(readOnly = true)
    @Override
    public Optional<Multa> findById(@NotNull Long multaId) {
        Multa multa = multaRepository.findOne(multaId);
        return Optional.ofNullable(multa);
    }

    @Override
    public Multa save(@NotNull @Valid Multa multa) {
        if(log.isDebugEnabled()){
            log.debug("Gravando multa: {}", multa);
        }
        return multaRepository.saveAndFlush(multa);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<List<Multa>> findByCondominio(Condominio condominio) {
        return Optional.ofNullable(multaRepository.findByCondominio(condominio));
    }

    @Override
    public void delete(Long multaId) {
        if (log.isDebugEnabled()) {
            log.debug("Removendo multa: {}", multaId);
        }
        multaRepository.delete(multaId);
    }

}
