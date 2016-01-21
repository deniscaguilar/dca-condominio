package br.com.dca.condominio.service.impl;

import br.com.dca.condominio.model.entity.Condominio;
import br.com.dca.condominio.model.entity.Torre;
import br.com.dca.condominio.model.repository.TorreRepository;
import br.com.dca.condominio.model.view.ListaTorre;
import br.com.dca.condominio.service.TorreService;
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
public class TorreServiceImpl implements TorreService {

    private static final Logger log = LoggerFactory.getLogger(TorreServiceImpl.class);

    @Autowired
    private TorreRepository torreRepository;

    @Transactional(readOnly = true)
    @Override
    public Optional<Torre> findById(@NotNull Long torreId) {
        Torre torre = torreRepository.findOne(torreId);
        return Optional.ofNullable(torre);
    }

    @Override
    public Torre save(@NotNull @Valid Torre torre) {
        if(log.isDebugEnabled()){
            log.debug("Gravando torre: {}", torre);
        }
        return torreRepository.saveAndFlush(torre);
    }

    @Transactional(readOnly = true)
    @Override
    public ListaTorre findByCondominio(Condominio condominio) {
        List<Torre> listaTorre = torreRepository.findByCondominio(condominio);
        return new ListaTorre(listaTorre.size(), listaTorre);
    }

    @Override
    public void delete(Long torreId) {
        if (log.isDebugEnabled()) {
            log.debug("Removendo torre: {}", torreId);
        }
        torreRepository.delete(torreId);
    }
}
