package com.ceiba.producto.modelo.entities;

import com.ceiba.detalle_factura.modelo.entities.DetalleFactura;
import com.ceiba.lote.modelo.entities.Lote;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
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
        return this.id == ((Producto)o).getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
