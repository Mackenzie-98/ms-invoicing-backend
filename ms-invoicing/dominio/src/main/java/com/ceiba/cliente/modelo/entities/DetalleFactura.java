package com.ceiba.cliente.modelo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "detalle_factura")
public class DetalleFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_detalle")
    private int id;

    @ManyToOne
    @JoinColumn(name="id_factura")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name="id_producto")
    private Producto producto;

    @Column
    private int cantidad;


}
