package br.com.dca.condominio.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by denis on 08/01/16.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "garagem")
@EqualsAndHashCode(exclude = "id", callSuper = false)
@ToString(exclude = "id")
public class Garagem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @Size(min = 1, max = 10, message = "{garagem.numero.size}")
    @NotNull(message = "{garagem.numero.notnull}")
    @Column(nullable = false, length = 10)
    @Getter @Setter
    private Integer numeroVaga;

    @NotNull(message = "{apartamento.notnull}")
    @ManyToOne
    @JoinColumn(name = "apartamento_id")
    @Getter @Setter
    private Apartamento apartamento;

    public Garagem() {
    }

    public Garagem(Date dataInclusao, String usuarioInclusao) {
        super(dataInclusao, usuarioInclusao);
    }

    public Garagem(Date dataInclusao, String usuarioInclusao, Date dataAlteracao, String usuarioAlteracao) {
        super(dataInclusao, usuarioInclusao, dataAlteracao, usuarioAlteracao);
    }

}
