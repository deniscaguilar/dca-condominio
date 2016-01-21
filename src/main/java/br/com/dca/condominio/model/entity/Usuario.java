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
@Table(name = "usuario")
@EqualsAndHashCode(exclude = "id", callSuper = false)
@ToString(exclude = "id")
public class Usuario extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @Size(min = 1, max = 20, message = "{usuario.size}")
    @NotNull(message = "{usuario.notnull}")
    @Column(nullable = false, length = 20)
    @Getter @Setter
    private String usuario;

    /**
     * Regra para criação da senha.
     *
     * (?=.*\d) # deve conter um digito de 0-9
     * (?=.*[a-z]) # deve conter pelo menos um caracter minusculo
     * (?=.*[A-Z]) # deve conter pelo menos um caracter maiusculo
     * (?=.*[@#$%]) # deve conter pelo menos um simbolo	especial contido na lista "@#$%"
     * . # match anything with previous condition checking
     * {6,20} # Tamanho minimo de 6 caracteres e maximo de 10
     */
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,10}", message = "{usuario.senha.formato.invalido}")
    @Size(min = 6, max = 10, message = "{usuario.senha.size}")
    @NotNull(message = "{usuario.senha.notnull}")
    @Column(nullable = false, length = 10)
    @Getter @Setter
    private String senha;

    @Size(min = 1, max = 100, message = "{email.size}")
    @Pattern(regexp = ".+@.+\\.[a-z]+", message = "{email.formato.invalido}")
    @NotNull(message = "{email.notnull}")
    @Column(name = "email", nullable = false, length = 100)
    @Getter @Setter
    private String email;

    @NotNull(message = "{perfil.notnull}")
    @ManyToOne
    @JoinColumn(name = "perfil_id")
    @Getter @Setter
    private Perfil perfil;

    @NotNull(message = "{condominio.notnull}")
    @ManyToOne
    @JoinColumn(name = "condominio_id")
    @Getter @Setter
    private Condominio condominio;

    public Usuario() {
    }

    public Usuario(Date dataInclusao, String usuarioInclusao) {
        super(dataInclusao, usuarioInclusao);
    }


    public Usuario(Date dataInclusao, String usuarioInclusao, Date dataAlteracao, String usuarioAlteracao) {
        super(dataInclusao, usuarioInclusao, dataAlteracao, usuarioAlteracao);
    }

}
