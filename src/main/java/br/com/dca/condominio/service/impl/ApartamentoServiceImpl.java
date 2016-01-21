package br.com.dca.condominio.service.impl;

import br.com.dca.condominio.model.entity.Apartamento;
import br.com.dca.condominio.model.entity.Torre;
import br.com.dca.condominio.model.repository.ApartamentoRepository;
import br.com.dca.condominio.service.ApartamentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

/**
 * Created by denis on 19/01/16.
 */
@Service
@Validated
@Transactional(rollbackFor = Exception.class)
public class ApartamentoServiceImpl implements ApartamentoService {

    private static final Logger log = LoggerFactory.getLogger(ApartamentoServiceImpl.class);

    @Autowired
    private ApartamentoRepository apartamentoRepository;

    @Transactional(readOnly = true)
    @Override
    public Optional<Apartamento> findById(Long apartamentoId) {
        Apartamento apartamento = apartamentoRepository.findOne(apartamentoId);
        return Optional.ofNullable(apartamento);
    }

    @Override
    public Apartamento save(Apartamento apartamento) {
        if(log.isDebugEnabled()){
            log.debug("Gravando apartamento: {}", apartamento);
        }
        return apartamentoRepository.saveAndFlush(apartamento);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<List<Apartamento>> findByTorre(Torre torre) {
        return Optional.ofNullable(apartamentoRepository.findByTorre(torre));
    }

    @Override
    public void delete(Long apartamentoId) {
        if (log.isDebugEnabled()) {
            log.debug("Removendo apartamento: {}", apartamentoId);
        }
        apartamentoRepository.delete(apartamentoId);
    }
}
