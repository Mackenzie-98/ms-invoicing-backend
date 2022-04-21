package com.ceiba.cliente.modelo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cliente")
public class Cliente {

    @Id
    private String identificacion;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    private List<Factura> facturas;
}
