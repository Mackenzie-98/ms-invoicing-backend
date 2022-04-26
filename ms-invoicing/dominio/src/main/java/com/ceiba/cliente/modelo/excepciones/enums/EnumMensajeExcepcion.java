package com.ceiba.cliente.modelo.excepciones.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum EnumMensajeExcepcion {
    NO_ENCONTRADO("I1", "No se encuentra ningun registro con ese id en la base de datos."),
    COMPRA_EXCEPCION("I2", "No se pudo ejecutar la compra.");

    private final String codigo;
    private final String mensaje;
}
