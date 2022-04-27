package com.ceiba.cliente.modelo.entities;

import com.ceiba.factura.modelo.entities.Factura;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "cliente")
public class Cliente {

    @Id
    private String identificacion;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Factura> facturas;
}
