package br.com.dca.condominio.model.enumeration;

/**
 * Created by denis on 08/01/16.
 */
public enum TipoCobranca {

    PERCENTUAL_CONDOMINO("P", "Percentual do condominio"), VALOR_CONDOMINIO("V", "Valor do Condominio");

    private String sigla;

    private String descricao;

    TipoCobranca(String sigla, String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public String getDescricao() {
        return descricao;
    }

}
