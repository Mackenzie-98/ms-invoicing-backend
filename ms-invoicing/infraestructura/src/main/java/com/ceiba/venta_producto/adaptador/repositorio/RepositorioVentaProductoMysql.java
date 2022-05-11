package com.ceiba.venta_producto.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.venta_producto.modelo.entidad.VentaProducto;
import com.ceiba.venta_producto.puerto.repositorio.RepositorioVentaProducto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioVentaProductoMysql implements RepositorioVentaProducto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace= "venta_producto", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace= "venta_producto", value="existePorId")
    private static String sqlExistePorId;

    public RepositorioVentaProductoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(VentaProducto ventaProducto,Long idFactura) {
        MapSqlParameterSource paramSource =  new MapSqlParameterSource();
        paramSource.addValue("idProducto", ventaProducto.getProducto().getId());
        paramSource.addValue("idFactura", idFactura);
        paramSource.addValue("cantidad", ventaProducto.getCantidad());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .update(sqlCrear, paramSource,keyHolder,new String[] { "id" });
        return keyHolder.getKey().longValue();
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
    }
}
