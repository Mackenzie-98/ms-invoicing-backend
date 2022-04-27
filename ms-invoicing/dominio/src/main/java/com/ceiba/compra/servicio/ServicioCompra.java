package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.detalle_factura.modelo.entities.DetalleFactura;
import com.ceiba.excepciones.ExcepcionTecnica;
import com.ceiba.factura.modelo.entities.Factura;
import com.ceiba.factura.puerto.dao.IDaoFactura;
import com.ceiba.producto.modelo.entities.Producto;
import com.ceiba.producto.puerto.dao.IDaoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.ceiba.excepciones.enums.EnumMensajeExcepcion.COMPRA_EXCEPCION;
import static com.ceiba.excepciones.enums.EnumMensajeExcepcion.COMPRA_NO_PERMITIDA_FIN_SEMANA;

@Service
public class ServicioCompra {

    @Autowired
    private IDaoProducto daoProducto;

    @Autowired
    private IDaoFactura daoFactura;


    public ResponseEntity<Factura> crearCompra(DtoCompra compra){

        if(esFinDeSemana(compra.getFactura().getFecha())){
            throw new ExcepcionTecnica(COMPRA_NO_PERMITIDA_FIN_SEMANA);
        }
        int cantidadProductos = compra.getIdProductos().size();
        Factura factura = compra.getFactura();
        List<DetalleFactura> listaCompra = new ArrayList<>();

        for(int i =0; i < cantidadProductos; i++){

            Optional<Producto> producto = daoProducto.buscarPorId(compra.getIdProductos().get(i));

            DetalleFactura detalleFactura = DetalleFactura.builder()
                    .producto(producto.get())
                    .factura(compra.getFactura())
                    .cantidad(compra.getCantidades().get(i))
                    .build();

                    listaCompra.add(detalleFactura);
        }
        factura.setDetalleFacturas(listaCompra);
        factura.setTotal(calcularTotalFactura(listaCompra));

        return new ResponseEntity(daoFactura.registrar(factura), HttpStatus.OK);
    }

    private boolean esFinDeSemana(LocalDate fecha){
        return fecha.getDayOfWeek()== DayOfWeek.SATURDAY || fecha.getDayOfWeek()== DayOfWeek.SUNDAY;
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
}
