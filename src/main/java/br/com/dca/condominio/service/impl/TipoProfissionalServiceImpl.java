package br.com.dca.condominio.service.impl;

import br.com.dca.condominio.model.entity.TipoProfissional;
import br.com.dca.condominio.model.repository.TipoProfissionalRepository;
import br.com.dca.condominio.model.view.ListaTipoProfissional;
import br.com.dca.condominio.service.TipoProfissionalService;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

/**
 * Created by denis on 13/01/16.
 */
@Service
@Validated
@Transactional(rollbackFor = Exception.class)
public class TipoProfissionalServiceImpl implements TipoProfissionalService {

    private static final Logger log = LoggerFactory.getLogger(TipoProfissionalServiceImpl.class);

    @Autowired
    private TipoProfissionalRepository tipoProfissionalRepository;

    @Transactional(readOnly = true)
    @Override
    public Optional<TipoProfissional> findById(Long tipoProfissionalId) {
        TipoProfissional tipoProfissional = tipoProfissionalRepository.findOne(tipoProfissionalId);
        return Optional.ofNullable(tipoProfissional);
    }

    @Transactional(readOnly = true)
    @Override
    public ListaTipoProfissional findAll() {
        long count = tipoProfissionalRepository.count();
        return new ListaTipoProfissional(count, Lists.newArrayList(tipoProfissionalRepository.findAll()));
    }
}
