package com.ceiba.compra.servicio;

import com.ceiba.cliente.modelo.entities.Cliente;
import com.ceiba.cliente.puerto.dao.IDaoCliente;
import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.detalle_factura.modelo.entities.DetalleFactura;
import com.ceiba.excepciones.ExcepcionTecnica;
import com.ceiba.factura.modelo.entities.Factura;
import com.ceiba.factura.puerto.dao.IDaoFactura;
import com.ceiba.producto.modelo.entities.Producto;
import com.ceiba.producto.puerto.dao.IDaoProducto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.ceiba.excepciones.enums.EnumMensajeExcepcion.COMPRA_NO_PERMITIDA_FIN_SEMANA;
import static com.ceiba.excepciones.enums.EnumMensajeExcepcion.NO_ENCONTRADO;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpStatus.OK;

@ExtendWith(MockitoExtension.class)
class ServicioCompraTest {

    @InjectMocks
    ServicioCompra servicioCompra;

    @Mock
    IDaoProducto daoProducto;

    @Mock
    IDaoFactura daoFactura;

    @Test
    void deberiaCrearUnaCompraCorrectamente() {
        //arrange
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

        Producto producto1= Producto.builder()
                .nombre("testName1")
                .precioUnitario(1500)
                .build();

        Producto producto2= Producto.builder()
                .nombre("testNam2e")
                .precioUnitario(1500)
                .build();

        DetalleFactura detalle1 = DetalleFactura.builder()
                .id(1)
                .factura(factura)
                .producto(producto1)
                .cantidad(2)
                .build();

        DetalleFactura detalle2 = DetalleFactura.builder()
                .id(2)
                .factura(factura)
                .producto(producto2)
                .cantidad(3)
                .build();

        factura.setDetalleFacturas(List.of(detalle1,detalle2));


        DtoCompra compra = DtoCompra.builder()
                .factura(factura)
                .idProductos(List.of(1,2))
                .cantidades(List.of(detalle1.getCantidad(),detalle2.getCantidad()))
                .build();

        when(daoProducto.buscarPorId(1)).thenReturn(Optional.of(producto1));
        when(daoProducto.buscarPorId(2)).thenReturn(Optional.of(producto2));
        when(daoFactura.registrar(factura)).thenReturn(factura);

        //act
        ResponseEntity<Factura> facturaCompra = servicioCompra.crearCompra(compra);

        //assert
        assertEquals(OK,facturaCompra.getStatusCode());
        assertEquals(cliente,facturaCompra.getBody().getCliente());
//        assertEquals(detalle1,facturaCompra.getBody().getDetalleFacturas().get(0));
//        assertEquals(detalle2,facturaCompra.getBody().getDetalleFacturas().get(1));
        assertEquals("Factura de prueba",facturaCompra.getBody().getDescripcion());
        assertEquals(createAt,facturaCompra.getBody().getFecha());
        assertEquals(calcularTotalFactura(factura.getDetalleFacturas()),facturaCompra.getBody().getTotal());
    }

    @Test
    void deberiaLanzarExcepcionAlComprarFinDeSemana() {
        //arrange
        LocalDate createAt = LocalDate.now();
        createAt = cambiarSiguienteFinDeSemana(createAt);

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

        Producto producto1= Producto.builder()
                .nombre("testName1")
                .precioUnitario(1500)
                .build();

        Producto producto2= Producto.builder()
                .nombre("testNam2e")
                .precioUnitario(1500)
                .build();

        DetalleFactura detalle1 = DetalleFactura.builder()
                .id(1)
                .factura(factura)
                .producto(producto1)
                .cantidad(2)
                .build();

        DetalleFactura detalle2 = DetalleFactura.builder()
                .id(2)
                .factura(factura)
                .producto(producto2)
                .cantidad(3)
                .build();

        factura.setDetalleFacturas(List.of(detalle1,detalle2));


        DtoCompra compra = DtoCompra.builder()
                .factura(factura)
                .idProductos(List.of(1,2))
                .cantidades(List.of(detalle1.getCantidad(),detalle2.getCantidad()))
                .build();

        //act

        ExcepcionTecnica excepcionTecnica= null;

        // act - assert
        try{
            servicioCompra.crearCompra(compra);
        }catch (ExcepcionTecnica e){
            excepcionTecnica = e;
        }

        //assert
        assertEquals(COMPRA_NO_PERMITIDA_FIN_SEMANA,excepcionTecnica.getMensajeExcepion());
    }

    private double calcularTotalFactura(List<DetalleFactura> detalleFactura){
        double total = 0;
        for (int i = 0; i < detalleFactura.size(); i++) {
            double costo = detalleFactura.get(i).getProducto().getPrecioUnitario();
            double cantidad = detalleFactura.get(i).getCantidad();
            total += costo*cantidad;
        }
        return total;
    }

    private LocalDate cambiarSiguienteFinDeSemana(LocalDate fecha){
        while(fecha.getDayOfWeek() != DayOfWeek.SATURDAY){
            fecha=fecha.plusDays(1);
        }
        return fecha;
    }

}