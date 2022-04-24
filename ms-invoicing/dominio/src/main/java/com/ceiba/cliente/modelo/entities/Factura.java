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

}
