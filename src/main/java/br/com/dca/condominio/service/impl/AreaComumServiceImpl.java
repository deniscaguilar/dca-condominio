package br.com.dca.condominio.service.impl;

import br.com.dca.condominio.model.entity.AreaComum;
import br.com.dca.condominio.model.entity.Condominio;
import br.com.dca.condominio.model.repository.AreaComumRepository;
import br.com.dca.condominio.service.AreaComumService;
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
public class AreaComumServiceImpl implements AreaComumService {

    private static final Logger log = LoggerFactory.getLogger(AreaComumServiceImpl.class);

    @Autowired
    private AreaComumRepository areaComumRepository;

    @Transactional(readOnly = true)
    @Override
    public Optional<AreaComum> findById(@NotNull Long areaComumId) {
        AreaComum areaComum = areaComumRepository.findOne(areaComumId);
        return Optional.ofNullable(areaComum);
    }

    @Override
    public AreaComum save(@NotNull @Valid AreaComum areaComum) {
        if(log.isDebugEnabled()){
            log.debug("Gravando area comum: {}", areaComum);
        }
        return areaComumRepository.saveAndFlush(areaComum);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<List<AreaComum>> findByCondominio(Condominio condominio) {
        return Optional.ofNullable(areaComumRepository.findByCondominio(condominio));
    }

    @Override
    public void delete(Long areaComumId) {
        if (log.isDebugEnabled()) {
            log.debug("Removendo areaComum: {}", areaComumId);
        }
        areaComumRepository.delete(areaComumId);
    }

}
