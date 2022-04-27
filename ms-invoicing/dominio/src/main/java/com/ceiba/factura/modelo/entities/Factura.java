package com.ceiba.factura.modelo.entities;

import com.ceiba.cliente.modelo.entities.Cliente;
import com.ceiba.detalle_factura.modelo.entities.DetalleFactura;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
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
    private LocalDate fecha;

    @Column(nullable = true)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name="id_cliente",referencedColumnName = "identificacion")
    private Cliente cliente;

    @OneToMany(mappedBy = "factura",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<DetalleFactura> detalleFacturas;

    @Column
    private double total;

    @Override
    public boolean equals(Object o) {
        Factura factura = (Factura) o;
        return id == factura.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
