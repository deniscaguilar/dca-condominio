package br.com.dca.condominio.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by denis on 08/01/16.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "multamorador")
@EqualsAndHashCode(exclude = "id", callSuper = false)
@ToString(exclude = "id")
public class MultaMorador extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @NotNull(message = "{morador.notnull}")
    @ManyToOne
    @JoinColumn(name = "morador_id")
    @Getter @Setter
    private Morador morador;

    @NotNull(message = "{multa.notnull}")
    @ManyToOne
    @JoinColumn(name = "multa_id")
    @Getter @Setter
    private Multa multa;

    @NotNull(message = "{multa.morador.valor.notnull}")
    @Size(min = 1, max = 9, message = "{multa.morador.valor.size}")
    @DecimalMax(value = "2", message = "{multa.morador.valor.decimal.max}")
    @Column(scale = 2, precision = 9, nullable = false)
    @Getter @Setter
    private BigDecimal valor;

    @Column(nullable = false, length = 1)
    @Getter @Setter
    private Boolean pago;

    @NotNull(message = "{multa.morador.data}")
    @Column(name = "datamulta", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter
    private Date dataMulta;

    public MultaMorador() {
    }

    public MultaMorador(Date dataInclusao, String usuarioInclusao) {
        super(dataInclusao, usuarioInclusao);
    }


    public MultaMorador(Date dataInclusao, String usuarioInclusao, Date dataAlteracao, String usuarioAlteracao) {
        super(dataInclusao, usuarioInclusao, dataAlteracao, usuarioAlteracao);
    }

}