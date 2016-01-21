package br.com.dca.condominio.model.view;

import br.com.dca.condominio.model.entity.Perfil;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by denis on 13/01/16.
 */
@SuppressWarnings("all")
public class ListaPerfil {

    @Getter
    private final List<Perfil> itens = new ArrayList<>();

    @Getter
    private final Long total;

    public ListaPerfil(Long total, List<Perfil> itens) {
        this.total = total;
        this.itens.addAll(itens);
    }

}
