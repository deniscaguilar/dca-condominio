package br.com.dca.condominio.model.enumeration;

/**
 * Created by denis on 07/01/16.
 */
public enum FormaPagamento {

    BOLETO("B", "Boleto");

    private String sigla;

    private String descricao;

    FormaPagamento(String sigla, String descricao) {
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
