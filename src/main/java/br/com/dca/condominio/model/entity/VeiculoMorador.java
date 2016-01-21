package br.com.dca.condominio.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by denis on 11/01/16.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "veiculomorador")
@EqualsAndHashCode(exclude = "id", callSuper = false)
@ToString(exclude = "id")
public class VeiculoMorador extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @NotNull(message = "{morador.notnull}")
    @ManyToOne
    @JoinColumn(name = "morador_id")
    @Getter @Setter
    private Morador morador;

    @NotNull(message = "{veiculo.notnull}")
    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    @Getter @Setter
    private Veiculo veiculo;

    public VeiculoMorador() {
    }

    public VeiculoMorador(Date dataInclusao, String usuarioInclusao) {
        super(dataInclusao, usuarioInclusao);
    }


    public VeiculoMorador(Date dataInclusao, String usuarioInclusao, Date dataAlteracao, String usuarioAlteracao) {
        super(dataInclusao, usuarioInclusao, dataAlteracao, usuarioAlteracao);
    }
}
