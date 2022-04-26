package com.ceiba.cliente.modelo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_factura")
    private int id;

    @Column
    private Date fecha;

    @Column(nullable = true)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name="id_cliente",referencedColumnName = "identificacion")
    private Cliente cliente;

    @OneToMany(mappedBy = "factura",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<DetalleFactura> detalleFacturas;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factura factura = (Factura) o;
        return id == factura.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
