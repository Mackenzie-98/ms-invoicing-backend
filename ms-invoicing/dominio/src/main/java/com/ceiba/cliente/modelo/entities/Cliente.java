package com.ceiba.cliente.modelo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private List<Factura> facturas;
}
