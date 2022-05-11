package com.ceiba.venta_producto.adaptador.dao;

import com.ceiba.producto.adaptador.dao.DaoProductoMysql;
import com.ceiba.producto.modelo.dto.DtoProducto;
import com.ceiba.venta_producto.modelo.dto.DtoVentaProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoVentaProducto implements RowMapper<DtoVentaProducto> {

    @Autowired
    private final DaoProductoMysql daoProducto;

    public MapeoVentaProducto(DaoProductoMysql daoProducto) {
        this.daoProducto = daoProducto;
    }


    @Override
    public DtoVentaProducto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        DtoProducto producto= daoProducto.buscarPorId(resultSet.getLong("id_producto"));
        Integer cantidad = resultSet.getInt("cantidad");
        return new DtoVentaProducto(id,producto,cantidad);
    }

}
