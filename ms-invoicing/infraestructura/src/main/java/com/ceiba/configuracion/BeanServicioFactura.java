package com.ceiba.configuracion;

import com.ceiba.factura.puerto.repositorio.RepositorioFactura;
import com.ceiba.factura.servicio.ServicioCrearFactura;
import com.ceiba.factura.servicio.ServicioEliminarFactura;
import com.ceiba.venta_producto.puerto.repositorio.RepositorioVentaProducto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioFactura {
    @Bean
    public ServicioCrearFactura servicioCrearFactura(RepositorioFactura repositorioFactura, RepositorioVentaProducto repositorioVentaProducto) {
        return new ServicioCrearFactura(repositorioFactura, repositorioVentaProducto);
    }

    @Bean
    public ServicioEliminarFactura servicioEliminarFactura(RepositorioFactura repositorioFactura) {
        return new ServicioEliminarFactura(repositorioFactura);
    }

}
