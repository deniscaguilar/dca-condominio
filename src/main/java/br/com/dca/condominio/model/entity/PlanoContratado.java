package br.com.dca.condominio.model.entity;

import br.com.dca.condominio.model.enumeration.FormaPagamento;
import br.com.dca.condominio.model.enumeration.TipoPlano;
import br.com.dca.condominio.model.enumeration.TipoTelefone;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by denis on 07/01/16.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "planocontratado")
@EqualsAndHashCode(exclude = "id", callSuper = false)
@ToString(exclude = "id")
public class PlanoContratado extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "{tipo.plano.notnull}")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipoplano", length = 10, nullable = false)
    @Getter @Setter
    private TipoPlano tipoPlano;

    @NotNull(message = "{plano.valor.notnull}")
    @Size(min = 1, max = 9, message = "{plano.valor.size}")
    @DecimalMax(value = "2", message = "{plano.valor.decimal.max}")
    @Column(scale = 2, precision = 9, nullable = false)
    @Getter @Setter
    private BigDecimal valor;

    @Column(nullable = false, length = 1)
    @Getter @Setter
    private Boolean ativo;

    @NotNull(message = "{plano.data.inicio.vigencia}")
    @Column(name = "datainiciovigencia", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter
    private Date dataInicioVigencia;

    @Column(name = "datafimvigencia")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter
    private Date dataFimVigencia;

    @NotNull(message = "{plano.forma.pagamento.notnull}")
    @Enumerated(EnumType.STRING)
    @Column(name = "formapagamento", length = 20, nullable = false)
    @Getter @Setter
    private FormaPagamento formaPagamento;

    @Column(name = "receberboletoporemail", nullable = false, length = 1)
    @Getter @Setter
    private Boolean receberBoletoPorEmail;

    @Size(min = 1, max = 100, message = "{plano.nome.responsavel.size}")
    @NotNull(message = "{plano.nome.responsavel.notnull}")
    @Column(name = "nomeresposavel", length = 100, nullable = false)
    @Getter @Setter
    private String nomeResponsavel;

    @Size(min = 1, max = 100, message = "{email.size}")
    @Pattern(regexp = ".+@.+\\.[a-z]+", message = "{email.formato.invalido}")
    @NotNull(message = "{email.notnull}")
    @Column(name = "emailresponsavel", nullable = false, length = 100)
    @Getter @Setter
    private String emailResponsavel;

    @NotNull(message = "{tipo.telefone.notnull}")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipotelefone", length = 20, nullable = false)
    @Getter @Setter
    private TipoTelefone tipoTelefone;

    @NotNull(message = "{telefone.notnull}")
    @Column(name = "telefoneresposavel", length = 11, nullable = false)
    @Getter @Setter
    private String telefoneResponsavel;

    @NotNull(message = "{condominio.notnull}")
    @ManyToOne
    @JoinColumn(name = "condominio_id")
    @Getter @Setter
    private Condominio condominio;

    public PlanoContratado() {
    }

    public PlanoContratado(Date dataInclusao, String usuarioInclusao) {
        super(dataInclusao, usuarioInclusao);
    }

    public PlanoContratado(Date dataInclusao, String usuarioInclusao, Date dataAlteracao, String usuarioAlteracao) {
        super(dataInclusao, usuarioInclusao, dataAlteracao, usuarioAlteracao);
    }

}
