package br.com.dca.condominio.model.view;

import br.com.dca.condominio.model.entity.Condominio;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by denis on 12/01/16.
 */
@SuppressWarnings("all")
public class ListaCondominio {

    @Getter
    private final List<Condominio> itens = new ArrayList<>();

    @Getter
    private final Long total;

    public ListaCondominio(Long total, List<Condominio> itens) {
        this.total = total;
        this.itens.addAll(itens);
    }

}
