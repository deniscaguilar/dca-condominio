package br.com.dca.condominio.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by denis on 11/01/16.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "visitante")
@EqualsAndHashCode(exclude = "id", callSuper = false)
@ToString(exclude = "id")
public class Visitante extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @Size(min = 1, max = 100, message = "{visitante.nome.size}")
    @NotNull(message = "{visitante.nome.notnull}")
    @Column(nullable = false, length = 100)
    @Getter @Setter
    private String nome;

    @Column(length = 12)
    @Getter @Setter
    private String rg;

    @Size(max = 14, message = "{cpf.size}")
    @Pattern(regexp = "[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}", message = "{cpf.formato.invalido}")
    @Column(length = 11)
    @Getter @Setter
    private String cpf;

    @Column(name = "datachegada")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter
    private Date dataChegada;

    @Column(name = "autorizadoentrada", nullable = false, length = 1)
    @Getter @Setter
    private Boolean autorizadoEntrada;

    @NotNull(message = "{veiculo.notnull}")
    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    @Getter @Setter
    private Veiculo veiculo;

    @NotNull(message = "{morador.notnull}")
    @ManyToOne
    @JoinColumn(name = "morador_id")
    @Getter @Setter
    private Morador morador;

    public Visitante() {
    }

    public Visitante(Date dataInclusao, String usuarioInclusao) {
        super(dataInclusao, usuarioInclusao);
    }


    public Visitante(Date dataInclusao, String usuarioInclusao, Date dataAlteracao, String usuarioAlteracao) {
        super(dataInclusao, usuarioInclusao, dataAlteracao, usuarioAlteracao);
    }

}
