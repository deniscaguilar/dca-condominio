package br.com.dca.condominio.model.entity;

import br.com.dca.condominio.model.enumeration.TipoTelefone;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by denis on 07/01/16.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "administradora")
@EqualsAndHashCode(exclude = "id", callSuper = false)
@ToString(exclude = "id")
public class Administradora extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @Size(min = 1, max = 100, message = "{administradora.nome.size}")
    @NotNull(message = "{administradora.nome.notnull}")
    @Column(nullable = false, length = 100)
    @Getter @Setter
    private String nome;

    @Size(min = 1, max = 100, message = "{administradora.contato.size}")
    @NotNull(message = "{administradora.contato.notnull}")
    @Column(length = 100, nullable = false)
    @Getter @Setter
    private String contato;

    @NotNull(message = "{tipo.telefone.notnull}")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipotelefone", length = 20, nullable = false)
    @Getter @Setter
    private TipoTelefone tipoTelefone;

    @NotNull(message = "{telefone.notnull}")
    @Column(length = 11, nullable = false)
    @Getter @Setter
    private Long telefone;

    @Size(min = 1, max = 100, message = "{email.size}")
    @Pattern(regexp = ".+@.+\\.[a-z]+", message = "{email.formato.invalido}")
    @NotNull(message = "{email.notnull}")
    @Column(name = "email", nullable = false, length = 100)
    @Getter @Setter
    private String email;

    @NotNull(message = "{condominio.notnull}")
    @ManyToOne
    @JoinColumn(name = "condominio_id")
    @Getter @Setter
    private Condominio condominio;

    public Administradora() {
    }

    public Administradora(Date dataInclusao, String usuarioInclusao) {
        super(dataInclusao, usuarioInclusao);
    }

    public Administradora(Date dataInclusao, String usuarioInclusao, Date dataAlteracao, String usuarioAlteracao) {
        super(dataInclusao, usuarioInclusao, dataAlteracao, usuarioAlteracao);
    }


}
