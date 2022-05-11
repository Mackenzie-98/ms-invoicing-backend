package com.ceiba.factura.adaptador.repositorio;

import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.puerto.repositorio.RepositorioFactura;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioFacturaMysql implements RepositorioFactura {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace= "factura", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace= "factura", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace= "factura", value="existePorId")
    private static String sqlExistePorId;

    public RepositorioFacturaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Factura factura) {
        MapSqlParameterSource paramSource =  new MapSqlParameterSource();
        paramSource.addValue("fecha", factura.getFecha());
        paramSource.addValue("descripcion", factura.getDescripcion());
        paramSource.addValue("idUsuario", factura.getUsuario().getId());
        paramSource.addValue("total", factura.getTotal());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .update(sqlCrear, paramSource,keyHolder,new String[] { "id" });
        return keyHolder.getKey().longValue();
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
    }
}
