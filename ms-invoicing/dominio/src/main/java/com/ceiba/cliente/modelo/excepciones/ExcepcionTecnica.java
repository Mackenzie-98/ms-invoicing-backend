package com.ceiba.cliente.modelo.excepciones;

import com.ceiba.cliente.modelo.excepciones.enums.EnumMensajeExcepcion;
import lombok.Getter;

@Getter
public class ExcepcionTecnica extends RuntimeException{
    private final EnumMensajeExcepcion mensajeExcepion;

    public ExcepcionTecnica(Throwable error, EnumMensajeExcepcion mensajeExcepion){
        super(mensajeExcepion.getMensaje(),error);
        this.mensajeExcepion = mensajeExcepion;
    }

    public ExcepcionTecnica(EnumMensajeExcepcion mensajeExcepion){
        super(mensajeExcepion.getMensaje());
        this.mensajeExcepion = mensajeExcepion;
    }
}
