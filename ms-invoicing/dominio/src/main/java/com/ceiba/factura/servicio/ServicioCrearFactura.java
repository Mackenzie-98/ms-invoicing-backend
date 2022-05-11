package com.ceiba.factura.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDiaNoHabil;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;
import com.ceiba.venta_producto.modelo.entidad.VentaProducto;
import com.ceiba.venta_producto.puerto.repositorio.RepositorioVentaProducto;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

public class ServicioCrearFactura {

    private static final String LA_FACTURA_YA_EXISTE_EN_EL_SISTEMA = "El factura ya existe en el sistema";


    private final RepositorioFactura repositorioFactura;

    private final RepositorioVentaProducto repositorioVentaProducto;

    public ServicioCrearFactura(RepositorioFactura repositorioFactura, RepositorioVentaProducto repositorioVentaProducto) {
        this.repositorioFactura = repositorioFactura;
        this.repositorioVentaProducto = repositorioVentaProducto;
    }

    public Long ejecutar(Factura factura) {
        validarExistenciaPrevia(factura);
//        validarFinDeSemana(factura.getFecha());
        List<VentaProducto> listaVenta = factura.getProductosVenta();
        Long id = this.repositorioFactura.crear(factura);

        for (int i = 0; i < listaVenta.size(); i++) {
            this.repositorioVentaProducto.crear(listaVenta.get(i),id);
        }

        return id;
    }

    private void validarExistenciaPrevia(Factura factura) {
        boolean existe = this.repositorioFactura.existePorId(factura.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_FACTURA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

//    private void validarFinDeSemana(LocalDateTime fecha){
//        boolean esFinDeSemana = fecha.getDayOfWeek()== DayOfWeek.SATURDAY || fecha.getDayOfWeek()== DayOfWeek.SUNDAY;
//        if(esFinDeSemana){
//            throw  new ExcepcionDiaNoHabil("Día no hábil para realizar compras, intente más tarde.");
//        }
//    }
}
