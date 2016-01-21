package br.com.dca.condominio.web.controller;

import br.com.dca.condominio.exception.ResourceNotFoundException;
import br.com.dca.condominio.model.entity.Condominio;
import br.com.dca.condominio.model.view.ListaCondominio;
import br.com.dca.condominio.service.CondominioService;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by denis on 04/01/16.
 */
@RestController
@RequestMapping(value = "/condominio")
public class CondominioController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(CondominioController.class);

    @Autowired
    private CondominioService condominioService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Condominio> findById(@PathVariable Long id){
        Optional<Condominio> optCondominio = condominioService.findById(id);

        if(!optCondominio.isPresent()){
            log.error("Condominio com o id {}, não encontrado.", id);
            throw new ResourceNotFoundException("Condomínio não encontrado.");
        }

        return ResponseEntity.ok(optCondominio.get());
    }

    @RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ListaCondominio> findAll(@RequestParam(defaultValue="0") Integer page) {
        Pageable pageable = new PageRequest(page, ITENS_POR_PAGINA);
        ListaCondominio listaCondominio = condominioService.findByPage(pageable);

        if (log.isDebugEnabled()) {
            log.debug("Consulta de condominios retornando {} registro(s).", listaCondominio.getItens().size());
        }

        return ResponseEntity.ok(listaCondominio);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Condominio> save(@RequestBody @Valid Condominio condominioRequest, BindingResult result){
        log.info("Condominio Request: {}", condominioRequest);

        validate(result);

        Condominio condominio = condominioService.save(condominioRequest);
        return ResponseEntity.ok(condominio);

    }

    @RequestMapping(method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Condominio> update(@RequestBody @Valid Condominio condominioRequest, BindingResult result) {
        log.info("Condominio Request: {}", condominioRequest);
        Preconditions.checkArgument(condominioRequest.getId() == null, "Problemas para atualizar o condomínio, o mesmo não possui id");

        validate(result);

        Condominio condominio = condominioService.save(condominioRequest);
        return ResponseEntity.ok(condominio);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id) {
        if(log.isDebugEnabled()) {
            log.debug("Id do Condominio: {}", id);
        }

        condominioService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}