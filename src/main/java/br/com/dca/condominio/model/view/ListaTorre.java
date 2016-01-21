package br.com.dca.condominio.model.view;

import br.com.dca.condominio.model.entity.Torre;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by denis on 19/01/16.
 */
public class ListaTorre {

    @Getter
    private final List<Torre> itens = new ArrayList<>();

    @Getter
    private final int total;

    public ListaTorre(int total, List<Torre> itens) {
        this.total = total;
        this.itens.addAll(itens);
    }

}
