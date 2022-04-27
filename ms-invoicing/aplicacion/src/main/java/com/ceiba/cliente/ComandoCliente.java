package com.ceiba.cliente;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCliente {
    private String identificacion;
    private String nombre;
    private String apellido;
}
