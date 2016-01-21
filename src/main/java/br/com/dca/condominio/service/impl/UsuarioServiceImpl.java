package br.com.dca.condominio.service.impl;

import br.com.dca.condominio.model.entity.Usuario;
import br.com.dca.condominio.model.repository.UsuarioRepository;
import br.com.dca.condominio.service.UsuarioService;
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
public class UsuarioServiceImpl implements UsuarioService {

    private static final Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario save(Usuario usuario) {
        if(log.isDebugEnabled()){
            log.debug("Gravando usuario: {}", usuario);
        }
        return usuarioRepository.saveAndFlush(usuario);
    }
}
