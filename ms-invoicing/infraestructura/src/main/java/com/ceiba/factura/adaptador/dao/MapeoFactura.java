package com.ceiba.factura.adaptador.dao;

import com.ceiba.factura.modelo.dto.DtoFactura;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.adaptador.dao.DaoUsuarioMysql;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.venta_producto.adaptador.dao.DaoVentaProductoMysql;
import com.ceiba.venta_producto.modelo.dto.DtoVentaProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class MapeoFactura implements RowMapper<DtoFactura>, MapperResult {

    @Autowired
    private final DaoVentaProductoMysql daoVentaProducto;

    @Autowired
    private final DaoUsuarioMysql daoUsuario;

    public MapeoFactura(DaoVentaProductoMysql daoVentaProducto, DaoUsuarioMysql daoUsuario) {
        this.daoVentaProducto = daoVentaProducto;
        this.daoUsuario = daoUsuario;
    }


    @Override
    public DtoFactura mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha");
        String descripcion = resultSet.getString("descripcion");
        DtoUsuario usuario =  daoUsuario.buscarPorId(resultSet.getLong("id_usuario"));
        List<DtoVentaProducto> ventaProductos  = daoVentaProducto.listarPorId(id);
        Double total = resultSet.getDouble("total");

        return new DtoFactura(id,fecha,descripcion,usuario,ventaProductos, total);
    }

}
