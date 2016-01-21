package br.com.dca.condominio.service.impl;

import br.com.dca.condominio.model.entity.Condominio;
import br.com.dca.condominio.model.repository.CondominioRepository;
import br.com.dca.condominio.model.view.ListaCondominio;
import br.com.dca.condominio.service.CondominioService;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * Created by denis on 04/01/16.
 */
@Service
@Validated
@Transactional(rollbackFor = Exception.class)
public class CondominioServiceImpl implements CondominioService {

    private static final Logger log = LoggerFactory.getLogger(CondominioServiceImpl.class);

    @Autowired
    private CondominioRepository condominioRepository;

    @Transactional(readOnly = true)
    @Override
    public Optional<Condominio> findById(@NotNull Long condominioId) {
        Condominio condominio = condominioRepository.findOne(condominioId);
        return Optional.ofNullable(condominio);
    }

    @Override
    public Condominio save(@NotNull @Valid Condominio condominio) {
        if(log.isDebugEnabled()){
            log.debug("Gravando condominio: {}", condominio);
        }
        return condominioRepository.saveAndFlush(condominio);
    }

    @Transactional(readOnly = true)
    @Override
    public ListaCondominio findByPage(Pageable page) {
        long count = condominioRepository.count();
        return new ListaCondominio(count, Lists.newArrayList(condominioRepository.findAll(page)));
    }

    @Override
    public void delete(@NotNull Long condominioId) {
        if (log.isDebugEnabled()) {
            log.debug("Removendo condominio: {}", condominioId);
        }
        condominioRepository.delete(condominioId);
    }
}
