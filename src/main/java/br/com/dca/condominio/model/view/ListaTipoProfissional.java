package br.com.dca.condominio.model.view;

import br.com.dca.condominio.model.entity.TipoProfissional;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by denis on 13/01/16.
 */
@SuppressWarnings("all")
public class ListaTipoProfissional {

    @Getter
    private final List<TipoProfissional> itens = new ArrayList<>();

    @Getter
    private final Long total;

    public ListaTipoProfissional(Long total, List<TipoProfissional> itens) {
        this.total = total;
        this.itens.addAll(itens);
    }

}
