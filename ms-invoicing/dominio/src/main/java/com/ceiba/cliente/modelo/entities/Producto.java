package com.ceiba.cliente.modelo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_producto")
    private int id;

    @Column
    private String nombre;

    @Column(name = "precio_unitario")
    private float precioUnitario;


}
