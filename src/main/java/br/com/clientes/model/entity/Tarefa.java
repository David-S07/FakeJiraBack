package br.com.clientes.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Date dataInicio;
    @Column
    private Date dataFim;
    @Column(nullable = false, length = 150)
    private String nomeTarefa;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "nome")
    private Usuario usuario;
    @Column
    private String statusTarefa;


}
