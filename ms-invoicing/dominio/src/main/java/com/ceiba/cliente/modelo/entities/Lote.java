package com.ceiba.cliente.modelo.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Builder
@Entity(name = "lote")
public class Lote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_lote")
    private int id;

    @Column
    private String laboratorio;

    @Column(name= "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;

    @Column
    private int cantidad;

    @ManyToOne
    @JoinColumn(name="id_producto")
    private Producto producto;

}
