package br.com.dca.condominio.model.entity;

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
@Table(name = "apartamento")
@EqualsAndHashCode(exclude = "id", callSuper = false)
@ToString(exclude = "id")
public class Apartamento extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @NotNull(message = "{apartamento.numero.notnull}")
    @Column(nullable = false, length = 10)
    @Getter @Setter
    private Integer numero;

    @NotNull(message = "{apartamento.qtde.vaga.garagem.notnull}")
    @Column(nullable = false, length = 3)
    @Getter @Setter
    private Integer quantidadeVagaGaragem;

    @NotNull(message = "{valor.condominio.notnull}")
    @Size(min = 1, max = 9, message = "{valor.condominio.size}")
    @DecimalMax(value = "2", message = "{valor.condominio.decimal.max}")
    @Column(name = "valorcondominio", scale = 2, precision = 9, nullable = false)
    @Getter @Setter
    private BigDecimal valorCondominio;

    @NotNull(message = "{torre.notnull}")
    @ManyToOne
    @JoinColumn(name = "torre_id")
    @Getter @Setter
    private Torre torre;

    public Apartamento() {
    }

    public Apartamento(Date dataInclusao, String usuarioInclusao) {
        super(dataInclusao, usuarioInclusao);
    }

    public Apartamento(Date dataInclusao, String usuarioInclusao, Date dataAlteracao, String usuarioAlteracao) {
        super(dataInclusao, usuarioInclusao, dataAlteracao, usuarioAlteracao);
    }

}
