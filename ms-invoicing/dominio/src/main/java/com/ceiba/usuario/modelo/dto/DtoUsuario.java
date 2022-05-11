package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoUsuario {
    private Long id;
    private String nombre;
    private String clave;
    private LocalDateTime fechaCreacion;

}
