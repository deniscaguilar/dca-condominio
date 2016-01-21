package br.com.dca.condominio.model.entity;

import br.com.dca.condominio.model.enumeration.Sexo;
import br.com.dca.condominio.model.enumeration.TipoTelefone;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * Created by denis on 08/01/16.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "morador")
@EqualsAndHashCode(exclude = "id", callSuper = false)
@ToString(exclude = "id")
public class Morador extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @Size(min = 1, max = 100, message = "{morador.nome.size}")
    @NotNull(message = "{morador.nome.notnull}")
    @Column(nullable = false, length = 100)
    @Getter @Setter
    private String nome;

    @NotNull(message = "{morador.data.nascimento.notnull}")
    @Column(nullable = false, length = 10)
    @Getter @Setter
    private Date dataNascimento;

    @NotNull(message = "{morador.sexo.notnull}")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    @Getter @Setter
    private Sexo sexo;

    @NotNull(message = "{tipo.telefone.notnull}")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipotelefone", length = 20, nullable = false)
    @Getter @Setter
    private TipoTelefone tipoTelefone;

    @NotNull(message = "{telefone.notnull}")
    @Column(name = "telefone", length = 11, nullable = false)
    @Getter @Setter
    private Long telefone;

    @Size(min = 1, max = 100, message = "{email.size}")
    @Pattern(regexp = ".+@.+\\.[a-z]+", message = "{email.formato.invalido}")
    @NotNull(message = "{email.notnull}")
    @Column(name = "email", nullable = false, length = 100)
    @Getter @Setter
    private String email;

    @Column(nullable = false, length = 1)
    @Getter @Setter
    private Boolean recebeBoletoEmail;

    @NotNull(message = "{apartamento.notnull}")
    @ManyToOne
    @JoinColumn(name = "apartamento_id")
    @Getter
    @Setter
    private Apartamento apartamento;

    @OneToMany(cascade = CascadeType.ALL)
    @Getter
    @Setter
    private List<MultaMorador> listaMultas;

    @OneToMany(cascade = CascadeType.ALL)
    @Getter
    @Setter
    private List<VeiculoMorador> listaVeiculos;

    @NotNull(message = "{usuario.notnull}")
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @Getter @Setter
    private Usuario usuario;

    public Morador() {
    }

    public Morador(Date dataInclusao, String usuarioInclusao) {
        super(dataInclusao, usuarioInclusao);
    }

    public Morador(Date dataInclusao, String usuarioInclusao, Date dataAlteracao, String usuarioAlteracao) {
        super(dataInclusao, usuarioInclusao, dataAlteracao, usuarioAlteracao);
    }

}
