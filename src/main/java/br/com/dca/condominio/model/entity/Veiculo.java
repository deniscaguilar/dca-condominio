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
@Table(name = "veiculo")
@EqualsAndHashCode(exclude = "id", callSuper = false)
@ToString(exclude = "id")
public class Veiculo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @Size(min = 1, max = 100, message = "{veiculo.marca.size}")
    @NotNull(message = "{veiculo.marca.notnull}")
    @Column(nullable = false, length = 100)
    @Getter @Setter
    private String marca;

    @Size(min = 1, max = 100, message = "{veiculo.modelo.size}")
    @NotNull(message = "{veiculo.modelo.notnull}")
    @Column(nullable = false, length = 100)
    @Getter @Setter
    private String modelo;

    @Size(min = 1, max = 30, message = "{veiculo.cor.size}")
    @NotNull(message = "{veiculo.cor.notnull}")
    @Column(nullable = false, length = 30)
    @Getter @Setter
    private String cor;

    @Size(min = 1, max = 4, message = "{veiculo.ano.fabricacao.size}")
    @NotNull(message = "{veiculo.ano.fabricacao.notnull}")
    @Column(nullable = false, length = 4)
    @Getter @Setter
    private Long anoFabricacao;

    @Size(min = 1, max = 4, message = "{veiculo.ano.modelo.size}")
    @NotNull(message = "{veiculo.ano.modelo.notnull}")
    @Column(nullable = false, length = 4)
    @Getter @Setter
    private Long anoModelo;

    @Size(min = 1, max = 10, message = "{veiculo.placa.size}")
    @NotNull(message = "{veiculo.placa.notnull}")
    @Column(nullable = false, length = 10)
    @Getter @Setter
    private String placa;

    public Veiculo() {
    }

    public Veiculo(Date dataInclusao, String usuarioInclusao) {
        super(dataInclusao, usuarioInclusao);
    }


    public Veiculo(Date dataInclusao, String usuarioInclusao, Date dataAlteracao, String usuarioAlteracao) {
        super(dataInclusao, usuarioInclusao, dataAlteracao, usuarioAlteracao);
    }

}
