package com.ceiba.excepciones.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum EnumMensajeExcepcion {
    NO_ENCONTRADO("I1", "No se encuentra ningun registro con ese id en la base de datos."),
    COMPRA_EXCEPCION("I2", "No se pudo ejecutar la compra."),
    COMPRA_NO_PERMITIDA_FIN_SEMANA("I3", "No se permite compras los fines de semana.");

    private final String codigo;
    private final String mensaje;
}
