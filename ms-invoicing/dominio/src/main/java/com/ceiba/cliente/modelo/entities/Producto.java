package com.ceiba.cliente.modelo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @OneToMany(mappedBy = "producto",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<DetalleFactura> detalleFacturas;

    @OneToMany(mappedBy = "producto",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Lote> lotes;

}
