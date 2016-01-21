package br.com.dca.condominio.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * Created by denis on 11/01/16.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "perfil")
@EqualsAndHashCode(exclude = "id", callSuper = false)
@ToString(exclude = "id")
public class Perfil extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @Size(min = 1, max = 100, message = "{perfil.nome.size}")
    @NotNull(message = "{perfil.nome.notnull}")
    @Column(nullable = false, length = 100)
    @Getter @Setter
    private String nome;

    @OneToMany(cascade = CascadeType.ALL)
    @Getter @Setter
    private List<Funcionalidade> funcionalidades;

    public Perfil() {
    }

    public Perfil(Date dataInclusao, String usuarioInclusao) {
        super(dataInclusao, usuarioInclusao);
    }


    public Perfil(Date dataInclusao, String usuarioInclusao, Date dataAlteracao, String usuarioAlteracao) {
        super(dataInclusao, usuarioInclusao, dataAlteracao, usuarioAlteracao);
    }

}
