package com.ceiba.cliente.modelo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Builder
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return id == producto.id && Float.compare(producto.precioUnitario, precioUnitario) == 0 && Objects.equals(nombre, producto.nombre);
    }
}
