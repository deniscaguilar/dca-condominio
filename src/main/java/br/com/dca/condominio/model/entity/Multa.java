package br.com.dca.condominio.model.entity;

import br.com.dca.condominio.model.enumeration.TipoCobranca;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
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
@Table(name = "multa")
@EqualsAndHashCode(exclude = "id", callSuper = false)
@ToString(exclude = "id")
public class Multa extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @Size(min = 1, max = 60, message = "{multa.nome.size}")
    @NotNull(message = "{multa.nome.notnull}")
    @Column(nullable = false, length = 60)
    @Getter @Setter
    private String nome;

    @Size(max = 255, message = "{descricao.size}")
    @Column(length = 255)
    @Getter @Setter
    private String descricao;

    @NotNull(message = "{tipo.cobranca.notnull}")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    @Getter @Setter
    private TipoCobranca tipoCobranca;

    @Size(min = 1, max = 3, message = "{multa.percentual.size}")
    @Column(length = 3)
    @Getter @Setter
    private Long percentual;

    @Size(min = 1, max = 9, message = "{multa.valor.size}")
    @DecimalMax(value = "2", message = "{multa.valor.decimal.max}")
    @Column(scale = 2, precision = 9)
    @Getter @Setter
    private BigDecimal valor;

    @NotNull(message = "{condominio.notnull}")
    @ManyToOne
    @JoinColumn(name = "condominio_id")
    @Getter @Setter
    private Condominio condominio;

    public Multa() {
    }

    public Multa(Date dataInclusao, String usuarioInclusao) {
        super(dataInclusao, usuarioInclusao);
    }


    public Multa(Date dataInclusao, String usuarioInclusao, Date dataAlteracao, String usuarioAlteracao) {
        super(dataInclusao, usuarioInclusao, dataAlteracao, usuarioAlteracao);
    }

}
