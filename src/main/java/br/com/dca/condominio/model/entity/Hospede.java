package br.com.dca.condominio.model.entity;

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

/**
 * Created by denis on 08/01/16.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "hospede")
@EqualsAndHashCode(exclude = "id", callSuper = false)
@ToString(exclude = "id")
public class Hospede extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @Size(min = 1, max = 100, message = "{hospede.nome.size}")
    @NotNull(message = "{hospede.nome.notnull}")
    @Column(nullable = false, length = 100)
    @Getter @Setter
    private String nome;

    @Size(min = 1, max = 100, message = "{email.size}")
    @Pattern(regexp = ".+@.+\\.[a-z]+", message = "{email.formato.invalido}")
    @NotNull(message = "{email.notnull}")
    @Column(name = "email", nullable = false, length = 100)
    @Getter @Setter
    private String email;

    @NotNull(message = "{tipo.telefone.notnull}")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipotelefone", length = 20, nullable = false)
    @Getter @Setter
    private TipoTelefone tipoTelefone;

    @NotNull(message = "{telefone.notnull}")
    @Column(length = 11, nullable = false)
    @Getter @Setter
    private Long telefone;

    @Size(max = 14, message = "{cpf.size}")
    @Pattern(regexp = "[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}", message = "{cpf.formato.invalido}")
    @Column(length = 11)
    @Getter @Setter
    private String cpf;

    @Column(name = "dataprevisaochegada")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter
    private Date dataPrevisaoChegada;

    @Column(name = "dataprevisaosaida")
    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter
    private Date dataPrevisaoSaida;

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    @Getter @Setter
    private Veiculo veiculo;

    @NotNull(message = "{morador.notnull}")
    @ManyToOne
    @JoinColumn(name = "morador_id")
    @Getter @Setter
    private Morador morador;

    public Hospede() {
    }

    public Hospede(Date dataInclusao, String usuarioInclusao) {
        super(dataInclusao, usuarioInclusao);
    }


    public Hospede(Date dataInclusao, String usuarioInclusao, Date dataAlteracao, String usuarioAlteracao) {
        super(dataInclusao, usuarioInclusao, dataAlteracao, usuarioAlteracao);
    }

}
