package com.ceiba.cliente.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cliente")
public class DtoCliente {

    @Id
    private String identificacion;

    @Column
    private String nombre;

    @Column
    private String apellido;
}
