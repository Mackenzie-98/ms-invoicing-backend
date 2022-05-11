package com.ceiba.usuario.modelo.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DtoUsuario {
    private Long id;
    private String nombre;
    private String clave;
    private LocalDateTime fechaCreacion;

    public DtoUsuario(){}

    public DtoUsuario(Long id, String nombre, String clave, LocalDateTime fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.fechaCreacion = fechaCreacion;
    }
}
