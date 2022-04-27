package com.ceiba.factura.servicio;

import com.ceiba.cliente.modelo.entities.Cliente;
import com.ceiba.excepciones.ExcepcionTecnica;
import com.ceiba.factura.modelo.entities.Factura;
import com.ceiba.factura.puerto.dao.IDaoFactura;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.ceiba.excepciones.enums.EnumMensajeExcepcion.NO_ENCONTRADO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;

@ExtendWith(MockitoExtension.class)
class ServicioFacturaTest {
    @InjectMocks
    ServicioFactura servicioFactura;

    @Mock
    IDaoFactura daoFactura;

    @Test
    void deberiaRegistrarFacturaCorrectamente() {
        // arrange
        LocalDate createAt = LocalDate.now();

        Cliente cliente = Cliente.builder()
                .identificacion("123")
                .nombre("testName")
                .apellido("testApellido")
                .build();

        Factura factura = Factura.builder()
                .id(1)
                .cliente(cliente)
                .descripcion("Factura de prueba")
                .fecha(createAt)
                .build();

        when(daoFactura.registrar(any(Factura.class))).thenReturn(factura);

        // act
        ResponseEntity<Factura> response = servicioFactura.registrarFactura(factura);

        //- assert
        assertEquals(OK, response.getStatusCode());
        assertEquals(factura, response.getBody());
    }

    @Test
    void deberiaBuscarFacturaPorIdCorrectamente() {
        // arrange
        LocalDate createAt = LocalDate.now();

        Cliente cliente = Cliente.builder()
                .identificacion("123")
                .nombre("testName")
                .apellido("testApellido")
                .build();

        Factura factura = Factura.builder()
                .id(1)
                .cliente(cliente)
                .descripcion("Factura de prueba")
                .fecha(createAt)
                .build();

        when(daoFactura.buscarPorId(1)).thenReturn(Optional.of(factura));

        // act
        ResponseEntity<Factura> response = servicioFactura.buscarFacturaPorId(1);

        //- assert
        assertEquals(OK, response.getStatusCode());
        assertEquals(factura, response.getBody());
    }

    @Test
    void deberiaListarFacturasCorrectamente() {
        LocalDate createAt = LocalDate.now();

        Cliente cliente = Cliente.builder()
                .identificacion("123")
                .nombre("testName")
                .apellido("testApellido")
                .build();

        Factura factura1 = Factura.builder()
                .id(1)
                .cliente(cliente)
                .descripcion("Factura de prueba")
                .fecha(createAt)
                .build();
        Factura factura2 = Factura.builder()
                .id(2)
                .cliente(cliente)
                .descripcion("Factura de prueba")
                .fecha(createAt)
                .build();

        List<Factura> facturas = Arrays.asList(factura1, factura2);
        when(daoFactura.listar()).thenReturn(facturas);

        // act
        ResponseEntity<List<Factura>> response = servicioFactura.listarFacturas();

        //- assert
        assertEquals(OK, response.getStatusCode());
        assertEquals(facturas, response.getBody());
    }

    @Test
    void deberiaEliminarUnaFacturaCorrectamente() {
        // arrange
        LocalDate createAt = LocalDate.now();

        Cliente cliente = Cliente.builder()
                .identificacion("123")
                .nombre("testName")
                .apellido("testApellido")
                .build();

        Factura factura = Factura.builder()
                .id(1)
                .cliente(cliente)
                .descripcion("Factura de prueba")
                .fecha(createAt)
                .build();

        when(daoFactura.eliminar(factura.getId())).thenReturn("Factura eliminada con exito.");

        // act
        ResponseEntity<String> response = servicioFactura.eliminarFactura(factura.getId());

        //- assert
        assertEquals(OK, response.getStatusCode());
        assertEquals("Factura eliminada con exito.", response.getBody());
    }

    @Test
    void deberiaLanzarExcepcionPorFacturaNoEncontrada() {
        // arrange
        LocalDate createAt = LocalDate.now();

        Cliente cliente = Cliente.builder()
                .identificacion("123")
                .nombre("testName")
                .apellido("testApellido")
                .build();

        Factura factura = Factura.builder()
                .id(1)
                .cliente(cliente)
                .descripcion("Factura de prueba")
                .fecha(createAt)
                .build();

        when(daoFactura.buscarPorId(factura.getId())).thenReturn(Optional.empty());
        ExcepcionTecnica excepcionTecnica= null;

        // act - assert
        try{
            servicioFactura.buscarFacturaPorId(factura.getId());
        }catch (ExcepcionTecnica e){
            excepcionTecnica = e;
        }
        assertEquals(NO_ENCONTRADO,excepcionTecnica.getMensajeExcepion());
    }
}