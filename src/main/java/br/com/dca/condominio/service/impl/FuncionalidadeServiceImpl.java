package br.com.dca.condominio.service.impl;

import br.com.dca.condominio.model.entity.Funcionalidade;
import br.com.dca.condominio.model.repository.FuncionalidadeRepository;
import br.com.dca.condominio.model.view.ListaFuncionalidade;
import br.com.dca.condominio.service.FuncionalidadeService;
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
public class FuncionalidadeServiceImpl implements FuncionalidadeService {

    private static final Logger log = LoggerFactory.getLogger(FuncionalidadeServiceImpl.class);

    @Autowired
    private FuncionalidadeRepository funcionalidadeRepository;

    @Transactional(readOnly = true)
    @Override
    public Optional<Funcionalidade> findById(@NotNull Long funcionalidadeId) {
        Funcionalidade funcionalidade = funcionalidadeRepository.findOne(funcionalidadeId);
        return Optional.ofNullable(funcionalidade);
    }

    @Override
    public Funcionalidade save(@NotNull @Valid Funcionalidade funcionalidade) {
        if(log.isDebugEnabled()){
            log.debug("Gravando funcionalidade: {}", funcionalidade);
        }
        return funcionalidadeRepository.saveAndFlush(funcionalidade);
    }

    @Transactional(readOnly = true)
    @Override
    public ListaFuncionalidade findAll() {
        long count = funcionalidadeRepository.count();
        return new ListaFuncionalidade(count, Lists.newArrayList(funcionalidadeRepository.findAll()));
    }

    @Override
    public void delete(@NotNull Long funcionalidadeId) {
        if (log.isDebugEnabled()) {
            log.debug("Removendo funcionalidade: {}", funcionalidadeId);
        }
        funcionalidadeRepository.delete(funcionalidadeId);
    }

}
