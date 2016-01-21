package br.com.dca.condominio.model.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by denis on 07/01/16.
 */
@MappedSuperclass
@SuppressWarnings("serial")
public class BaseEntity implements Serializable {

    @Column(name = "datainclusao", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;

    @Column(name = "usuarioalteracao", length = 20, nullable = false)
    private String usuarioInclusao;

    @Column(name = "dataalteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAlteracao;

    @Column(name = "usuarioalteracao", length = 20)
    private String usuarioAlteracao;

    public BaseEntity() {
    }

    public BaseEntity(Date dataInclusao, String usuarioInclusao, Date dataAlteracao, String usuarioAlteracao) {
        this.dataInclusao = dataInclusao;
        this.usuarioInclusao = usuarioInclusao;
        this.dataAlteracao = dataAlteracao;
        this.usuarioAlteracao = usuarioAlteracao;
    }

    public BaseEntity(Date dataAlteracao, String usuarioAlteracao) {
        this.dataAlteracao = dataAlteracao;
        this.usuarioAlteracao = usuarioAlteracao;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public String getUsuarioInclusao() {
        return usuarioInclusao;
    }

    public void setUsuarioInclusao(String usuarioInclusao) {
        this.usuarioInclusao = usuarioInclusao;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public String getUsuarioAlteracao() {
        return usuarioAlteracao;
    }

    public void setUsuarioAlteracao(String usuarioAlteracao) {
        this.usuarioAlteracao = usuarioAlteracao;
    }

}
