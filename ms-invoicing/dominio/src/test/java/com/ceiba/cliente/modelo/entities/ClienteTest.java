package com.ceiba.cliente.modelo.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClienteTest {

    @Test
    void deberiaCrearCorrectamenteElCliente() {
        // arrange - act
        Cliente cliente = Cliente.builder()
                .identificacion("123")
                .nombre("Edinsson")
                .apellido("Melo")
                .facturas(null)
                .build();

        //assert
        assertEquals("123", cliente.getIdentificacion());
        assertEquals("Edinsson", cliente.getNombre());
        assertEquals("Melo", cliente.getApellido());
    }

//    @Test
//    void deberiaFallarSinNombreDeCliente() {
//
//        //Arrange
//        Cliente cliente = Cliente.builder().build();
//
//        //act-assert
//        BasePrueba.assertThrows(() -> {
//                    usuarioBuilderTest.build();
//                },
//                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre de usuario");
//    }
//
//    @Test
//    void deberiaFallarSinClave() {
//
//        //Arrange
//        UsuarioBuilderTest usuarioBuilderTest = new UsuarioBuilderTest().conClave(null).conId(1L);
//        //act-assert
//        BasePrueba.assertThrows(() -> {
//                    usuarioBuilderTest.build();
//                },
//                ExcepcionValorObligatorio.class, "Se debe ingresar la clave");
//    }
//
//    @Test
//    void deberiaFallarSinTamanioClave() {
//
//        //Arrange
//        UsuarioBuilderTest usuarioBuilderTest = new UsuarioBuilderTest().conClave("123").conId(1L);
//        //act-assert
//        BasePrueba.assertThrows(() -> {
//                    usuarioBuilderTest.build();
//                },
//                ExcepcionLongitudValor.class, "La clave debe tener una longitud mayor o igual a 4");
//    }
//
//    @Test
//    void deberiaFallarSinFechaCreacion() {
//
//        //Arrange
//        UsuarioBuilderTest usuarioBuilderTest = new UsuarioBuilderTest().conFechaCreacion(null).conId(1L);
//        //act-assert
//        BasePrueba.assertThrows(() -> {
//                    usuarioBuilderTest.build();
//                },
//                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de creación");
//    }


}
