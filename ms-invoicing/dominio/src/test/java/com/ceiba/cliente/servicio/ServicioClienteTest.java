package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entities.Cliente;
import com.ceiba.cliente.puerto.dao.IDaoCliente;
import com.ceiba.excepciones.ExcepcionTecnica;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.ceiba.excepciones.enums.EnumMensajeExcepcion.NO_ENCONTRADO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;

@ExtendWith(MockitoExtension.class)
class ServicioClienteTest {

    @InjectMocks
    ServicioCliente servicioCliente;

    @Mock
    IDaoCliente daoCliente;

    @Test
    void deberiaRegistrarElClienteCorrectamente() {
        // arrange
        Cliente cliente = Cliente.builder()
                .identificacion("123")
                .nombre("testName")
                .apellido("testApellido")
                .build();
        when(daoCliente.registrar(any(Cliente.class))).thenReturn(cliente);

        // act
        ResponseEntity<Cliente> response = servicioCliente.registrarCliente(cliente);

        //- assert
        assertEquals(OK,response.getStatusCode());
        assertEquals(cliente,response.getBody());
    }
    @Test
    void deberiaEliminarUnClienteCorrectamente() {
        // arrange
        Cliente cliente = Cliente.builder()
                .identificacion("123")
                .nombre("testName")
                .apellido("testApellido")
                .build();
        when(daoCliente.eliminar(cliente.getIdentificacion())).thenReturn("Cliente eliminado correctamente.");

        // act
        ResponseEntity<String> response = servicioCliente.eliminarCliente(cliente.getIdentificacion());

        //- assert
        assertEquals(OK,response.getStatusCode()) ;
        assertEquals("Cliente eliminado correctamente.",response.getBody());
    }

    @Test
    void deberiaBuscarPorIdCorrectamente() {
        // arrange
        Cliente cliente = Cliente.builder()
                .identificacion("123")
                .nombre("testName")
                .apellido("testApellido")
                .build();
        when(daoCliente.buscarPorId(cliente.getIdentificacion())).thenReturn(Optional.of(cliente));

        // act
        ResponseEntity<Cliente> response = servicioCliente.buscarClientePorId(cliente.getIdentificacion());

        //- assert
        assertEquals(OK,response.getStatusCode()) ;
        assertEquals(cliente,response.getBody());
    }

    @Test
    void deberiaListarClientesCorrectamente() {
        // arrange
        Cliente cliente1 = Cliente.builder()
                .identificacion("123")
                .nombre("testName")
                .apellido("testApellido")
                .build();

        Cliente cliente2 = Cliente.builder()
                .identificacion("123")
                .nombre("testName")
                .apellido("testApellido")
                .build();
        List<Cliente> listaClientes = Arrays.asList(cliente1, cliente2);

        when(daoCliente.listar()).thenReturn(listaClientes);

        // act
        ResponseEntity<List<Cliente>> response = servicioCliente.listarClientes();

        //- assert
        assertEquals(OK,response.getStatusCode());
        assertEquals(listaClientes,response.getBody());
    }

    @Test
    void deberiaLanzarExcepcionPorClienteNoEncontrado() {
        // arrange
        Cliente cliente = Cliente.builder()
                .identificacion("123")
                .nombre("testName")
                .apellido("testApellido")
                .build();

        when(daoCliente.buscarPorId(cliente.getIdentificacion())).thenReturn(Optional.empty());
        ExcepcionTecnica excepcionTecnica= null;

        // act - assert
        try{
            servicioCliente.buscarClientePorId(cliente.getIdentificacion());
        }catch (ExcepcionTecnica e){
            excepcionTecnica = e;
        }
        assertEquals(excepcionTecnica.getMensajeExcepion(),NO_ENCONTRADO);
    }
}