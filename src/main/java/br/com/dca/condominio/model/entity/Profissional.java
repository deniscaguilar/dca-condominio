package br.com.dca.condominio.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by denis on 11/01/16.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "profissional")
@EqualsAndHashCode(exclude = "id", callSuper = false)
@ToString(exclude = "id")
public class Profissional extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @Size(min = 1, max = 100, message = "{profissional.nome.size}")
    @NotNull(message = "{profissional.nome.notnull}")
    @Column(nullable = false, length = 100)
    @Getter @Setter
    private String nome;

    @Size(max = 14, message = "{cpf.size}")
    @Pattern(regexp = "[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}", message = "{cpf.formato.invalido}")
    @Column(length = 11)
    @Getter @Setter
    private String cpf;

    @Column(nullable = false, length = 1)
    @Getter @Setter
    private Boolean ativo;

    @Column(name = "dataexpiracaoacesso")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter
    private Date dataExpiracaoAcesso;

    @NotNull(message = "{tipo.profissional.notnull}")
    @ManyToOne
    @JoinColumn(name = "tipoprofissional_id")
    @Getter @Setter
    private TipoProfissional tipoProfissional;

    @Size(max = 255, message = "{descricao.size}")
    @Column(nullable = false, length = 255)
    @Getter @Setter
    private String descricao;

    @NotNull(message = "{morador.notnull}")
    @ManyToOne
    @JoinColumn(name = "morador_id")
    @Getter @Setter
    private Morador morador;

    public Profissional() {
    }

    public Profissional(Date dataInclusao, String usuarioInclusao) {
        super(dataInclusao, usuarioInclusao);
    }

    public Profissional(Date dataInclusao, String usuarioInclusao, Date dataAlteracao, String usuarioAlteracao) {
        super(dataInclusao, usuarioInclusao, dataAlteracao, usuarioAlteracao);
    }

}
