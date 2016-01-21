package br.com.dca.condominio.model.enumeration;

/**
 * Created by denis on 07/01/16.
 */
public enum TipoPlano {

    MENSAL("M", "Mensal"), TRIMESTRAL("T", "Trimestral"), SEMESTRAL("S", "Semestral"), ANUAL("A", "Anual");

    private String sigla;

    private String descricao;

    TipoPlano(String sigla, String descricao) {
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
