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
 * Created by denis on 07/01/16.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "torre")
@EqualsAndHashCode(exclude = "id", callSuper = false)
@ToString(exclude = "id")
public class Torre extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @Size(min = 1, max = 100, message = "{torre.nome.size}")
    @NotNull(message = "{torre.nome.notnull}")
    @Column(nullable = false, length = 100)
    @Getter @Setter
    private String nome;

    @NotNull(message = "{valor.condominio.notnull}")
    @Size(min = 1, max = 9, message = "{valor.condominio.size}")
    @DecimalMax(value = "2", message = "{valor.condominio.decimal.max}")
    @Column(name = "valorcondominio", scale = 2, precision = 9, nullable = false)
    @Getter @Setter
    private BigDecimal valorCondominio;

    @NotNull(message = "{condominio.notnull}")
    @ManyToOne
    @JoinColumn(name = "condominio_id")
    @Getter @Setter
    private Condominio condominio;

    public Torre() {
    }

    public Torre(Date dataInclusao, String usuarioInclusao) {
        super(dataInclusao, usuarioInclusao);
    }

    public Torre(Date dataInclusao, String usuarioInclusao, Date dataAlteracao, String usuarioAlteracao) {
        super(dataInclusao, usuarioInclusao, dataAlteracao, usuarioAlteracao);
    }

}
