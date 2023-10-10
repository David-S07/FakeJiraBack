package br.com.clientes.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class SubTarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSubTarefa;
    @Column
    private Date dataInicio;
    @Column
    private Date dataFim;
    @Column(nullable = false, length = 150)
    private String nomeTarefa;

    @Column
    private String statusTarefa;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private SubTarefa subTarefa;

}
