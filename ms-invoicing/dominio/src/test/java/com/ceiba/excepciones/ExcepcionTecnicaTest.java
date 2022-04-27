package com.ceiba.excepciones;

import com.ceiba.excepciones.enums.EnumMensajeExcepcion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExcepcionTecnicaTest {

    @Test
    void deberiaValidarCorrectamenteElMensajeExcepcion(){
        EnumMensajeExcepcion mensajeExcepcion = EnumMensajeExcepcion.NO_ENCONTRADO;
        ExcepcionTecnica ejecucion = new ExcepcionTecnica(new Throwable(), mensajeExcepcion);
        assertNotNull(ejecucion);
        assertEquals(mensajeExcepcion.getMensaje(), ejecucion.getMensajeExcepion().getMensaje());
        assertEquals(mensajeExcepcion.getCodigo(),ejecucion.getMensajeExcepion().getCodigo());
    }

}