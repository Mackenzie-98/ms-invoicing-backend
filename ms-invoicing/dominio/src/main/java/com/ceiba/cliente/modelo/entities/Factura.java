package com.ceiba.cliente.modelo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_factura")
    private int id;

    @Column
    private Date fecha;

    @Column
    private String descripcion;

    @ManyToOne
    @JoinColumn(name="id_cliente",referencedColumnName = "identificacion")
    private Cliente cliente;
}
