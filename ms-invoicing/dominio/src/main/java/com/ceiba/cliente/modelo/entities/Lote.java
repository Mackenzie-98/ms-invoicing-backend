package com.ceiba.cliente.modelo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "lote")
public class Lote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_lote")
    private int id;

    @Column
    private String laboratorio;

    @Column(name= "fecha_vencimiento")
    private Date fechaVencimiento;

    @Column
    private int cantidad;

    @Column
    private int id_producto;

}
