package br.com.dca.condominio.model.view;

import br.com.dca.condominio.model.entity.Funcionalidade;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by denis on 13/01/16.
 */
@SuppressWarnings("all")
public class ListaFuncionalidade {

    @Getter
    private final List<Funcionalidade> itens = new ArrayList<>();

    @Getter
    private final Long total;

    public ListaFuncionalidade(Long total, List<Funcionalidade> itens) {
        this.total = total;
        this.itens.addAll(itens);
    }


}
