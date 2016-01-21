package br.com.dca.condominio.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by denis on 11/01/16.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "tipoprofissional")
@EqualsAndHashCode(exclude = "id", callSuper = false)
@ToString(exclude = "id")
public class TipoProfissional extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @Size(min = 1, max = 100, message = "{tipo.profissional.nome.size}")
    @NotNull(message = "{tipo.profissional.nome.notnull}")
    @Column(nullable = false, length = 100)
    @Getter @Setter
    private String nome;

    public TipoProfissional() {
    }

    public TipoProfissional(Date dataInclusao, String usuarioInclusao) {
        super(dataInclusao, usuarioInclusao);
    }

    public TipoProfissional(Date dataInclusao, String usuarioInclusao, Date dataAlteracao, String usuarioAlteracao) {
        super(dataInclusao, usuarioInclusao, dataAlteracao, usuarioAlteracao);
    }

}
