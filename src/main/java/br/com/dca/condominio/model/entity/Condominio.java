package br.com.dca.condominio.model.entity;

import com.google.common.base.Objects;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by denis on 04/01/16.
 */
@Entity
@Table(name = "condominio")
@SuppressWarnings("serial")
public class Condominio extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 1, max = 100, message = "{condominio.nome.size}")
    @NotNull(message = "{condominio.nome.notnull}")
    @Column(nullable = false, length = 100)
    private String nome;

    @Size(max = 18, message = "condominio.cnpj.size")
    @Pattern(regexp = "[0-9]{2}\\.?[0-9]{3}\\.?[0-9]{3}\\/?[0-9]{4}\\-?[0-9]{2}", message = "{condominio.cnpj.formato.invalido}")
    @Column(length = 14)
    private String cnpj;

    @Column(name = "torreunica", nullable = false, length = 1)
    private Boolean torreUnica;

    @Size(max = 9, message = "{condominio.cep.size}")
    @Pattern(regexp = "\\d{5}-?\\d{3}", message = "{condominio.cep.formato.invalido}")
    @NotNull(message = "{condominio.cep.notnull}")
    @Column(length = 8, nullable = false)
    private String cep;

    @Size(min = 1, max = 200, message = "{condominio.logradouro.size}")
    @NotNull(message = "{condominio.logradouro.notnull}")
    @Column(nullable = false, length = 200)
    private String logradouro;

    @Size(min = 1, max = 20, message = "{condominio.numero.size}")
    @NotNull(message = "{condominio.numero.notnull}")
    @Column(nullable = false, length = 20)
    private String numero;

    @Size(min = 1, max = 80, message = "{condominio.complemento.size}")
    @Column(length = 80)
    private String complemento;

    @Size(min = 1, max = 100, message = "{condominio.bairro.size}")
    @Column(length = 100)
    private String bairro;

    @Size(max = 120, message = "{condominio.cidade.size}")
    @NotNull(message = "{condominio.cidade.notnull}")
    @Column(nullable = false, length = 120)
    private String cidade;

    @NotNull(message = "{condominio.estado.notnull}")
    @Column(nullable = false, length = 2)
    private String estado;

    @NotNull(message = "{usuario.notnull}")
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @Getter @Setter
    private Usuario usuario;

    public Condominio() {
    }

    public Condominio(Date dataInclusao, String usuarioInclusao) {
        super(dataInclusao, usuarioInclusao);
    }


    public Condominio(Date dataInclusao, String usuarioInclusao, Date dataAlteracao, String usuarioAlteracao) {
        super(dataInclusao, usuarioInclusao, dataAlteracao, usuarioAlteracao);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Boolean getTorreUnica() {
        return torreUnica;
    }

    public void setTorreUnica(Boolean torreUnica) {
        this.torreUnica = torreUnica;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() { return numero; }

    public String getComplemento() { return complemento; }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Condominio [nome=" + nome + ", cnpj=" + cnpj + ", torreUnica=" + torreUnica + ", cep=" + cep + ", logradouro=" + logradouro + ", numero=" + numero + ", complemento=" + complemento + ", cidade=" + cidade + ", estado=" + estado + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.nome, this.cnpj, this.torreUnica, this.cep, this.logradouro, this.numero, this.complemento, this.bairro, this.cidade, this.estado);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Condominio outro = (Condominio) obj;
        return Objects.equal(this.nome, outro.nome) && Objects.equal(this.cnpj, outro.cnpj) && Objects.equal(this.torreUnica, outro.torreUnica)
                && Objects.equal(this.cep, outro.cep) && Objects.equal(this.logradouro, outro.logradouro) && Objects.equal(this.numero, outro.numero)
                && Objects.equal(this.complemento, outro.complemento) && Objects.equal(this.bairro, outro.bairro) && Objects.equal(this.cidade, outro.cidade)
                && Objects.equal(this.estado, outro.estado);
    }

}