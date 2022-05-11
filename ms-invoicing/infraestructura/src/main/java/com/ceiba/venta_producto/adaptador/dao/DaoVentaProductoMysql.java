package com.ceiba.venta_producto.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.venta_producto.modelo.dto.DtoVentaProducto;
import com.ceiba.venta_producto.puerto.dao.DaoVentaProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoVentaProductoMysql implements DaoVentaProducto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @Autowired
    private final MapeoVentaProducto mapeoVentaProducto;
    @SqlStatement(namespace= "venta_producto", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace= "venta_producto", value="listarPorId")
    private static String sqlListarPorId;

    public DaoVentaProductoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoVentaProducto mapeoVentaProducto) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoVentaProducto = mapeoVentaProducto;
    }

    @Override
    public List<DtoVentaProducto> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, mapeoVentaProducto);
    }
    @Override
    public List<DtoVentaProducto> listarPorId(Long idFactura){
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idFactura", idFactura);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorId, paramSource, mapeoVentaProducto);
    }
}
