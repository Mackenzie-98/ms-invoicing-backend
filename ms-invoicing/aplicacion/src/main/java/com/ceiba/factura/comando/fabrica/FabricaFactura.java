package com.ceiba.factura.comando.fabrica;

import com.ceiba.factura.comando.ComandoFactura;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import com.ceiba.venta_producto.modelo.dto.DtoVentaProducto;
import com.ceiba.venta_producto.modelo.entidad.VentaProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDateTime.now;


@Component
public class FabricaFactura {

    @Autowired
    private final DaoUsuario daoUsuario;

    public FabricaFactura(DaoUsuario daoUsuario) {
        this.daoUsuario = daoUsuario;
    }

    public Factura crear(ComandoFactura comandoFactura) {
        DtoUsuario usuario = daoUsuario.buscarPorId(comandoFactura.getUsuario().getId());
        return new Factura(
                comandoFactura.getId(),
                now(),
                comandoFactura.getDescripcion(),
                comandoFactura.getTotal(),
                new Usuario(usuario.getId(),
                        usuario.getNombre(),
                        usuario.getClave(),
                        usuario.getFechaCreacion()),
                crearProductosVenta(comandoFactura.getProductosVenta()));
    }

    private List<VentaProducto> crearProductosVenta(List<DtoVentaProducto> ventaProductos){
        List<VentaProducto> listaVentas = new ArrayList<>();
        for (int i = 0; i < ventaProductos.size(); i++) {
            DtoVentaProducto dtoVenta = ventaProductos.get(i);
            VentaProducto venta = new VentaProducto(dtoVenta.getId(),
                                                    new Producto(dtoVenta.getProducto().getId(),
                                                                 dtoVenta.getProducto().getNombre(),
                                                                 dtoVenta.getProducto().getPrecioUnitario()),
                                                    dtoVenta.getCantidad());
            listaVentas.add(venta);
        }
        return listaVentas;
    }

}
