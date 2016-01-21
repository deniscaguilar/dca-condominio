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
@Table(name = "areacomum")
@EqualsAndHashCode(exclude = "id", callSuper = false)
@ToString(exclude = "id")
public class AreaComum extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @Size(min = 1, max = 60, message = "{areacomum.nome.size}")
    @NotNull(message = "{areacomum.nome.notnull}")
    @Column(nullable = false, length = 60)
    @Getter @Setter
    private String nome;

    @Size(max = 255, message = "{descricao.size}")
    @Column(length = 255)
    @Getter @Setter
    private String descricao;

    @Size(max = 100, message = "{areacomum.localizacao.size}")
    @Column(length = 100)
    @Getter @Setter
    private String localizacao;

    @Size(max = 50, message = "{areacomum.arquivo.nome.size}")
    @Column(length = 50)
    @Getter @Setter
    private String arquivoRegulamento;

    @Column(nullable = false, length = 1)
    private Boolean necessarioReservar;

    @Column(nullable = false, length = 1)
    private Boolean necessarioAlugar;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    @Getter @Setter
    private TipoCobranca tipoCobranca;

    @Size(min = 1, max = 9, message = "{valor.aluguel.size}")
    @DecimalMax(value = "2", message = "{valor.aluguel.decimal.max}")
    @Column(scale = 2, precision = 9)
    @Getter @Setter
    private BigDecimal valorAluguel;

    @Size(min = 1, max = 3, message = "{percentual.aluguel.size}")
    @Column(length = 3)
    @Getter @Setter
    private Integer percentualAluguel;

    @NotNull(message = "{condominio.notnull}")
    @ManyToOne
    @JoinColumn(name = "condominio_id")
    @Getter @Setter
    private Condominio condominio;

    public AreaComum() {
    }

    public AreaComum(Date dataInclusao, String usuarioInclusao) {
        super(dataInclusao, usuarioInclusao);
    }

    public AreaComum(Date dataInclusao, String usuarioInclusao, Date dataAlteracao, String usuarioAlteracao) {
        super(dataInclusao, usuarioInclusao, dataAlteracao, usuarioAlteracao);
    }

}
