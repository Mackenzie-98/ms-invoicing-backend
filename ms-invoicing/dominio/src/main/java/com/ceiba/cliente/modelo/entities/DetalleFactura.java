package com.ceiba.cliente.modelo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@Entity(name = "detalle_factura")
public class DetalleFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_detalle")
    private int id;

    @ManyToOne
    @JoinColumn(name="id_factura")
    @JsonBackReference
    private Factura factura;

    @ManyToOne
    @JoinColumn(name="id_producto")
    private Producto producto;

    @Column
    private int cantidad;


}
