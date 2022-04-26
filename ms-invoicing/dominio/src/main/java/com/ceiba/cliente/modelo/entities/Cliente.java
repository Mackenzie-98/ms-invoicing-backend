package com.ceiba.cliente.modelo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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

    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Factura> facturas;
}
