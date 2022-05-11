package com.ceiba.factura.adaptador.dao;

import com.ceiba.factura.modelo.dto.DtoFactura;
import com.ceiba.factura.puerto.dao.DaoFactura;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoFacturaMysql implements DaoFactura {

    @Autowired
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @Autowired
    private final MapeoFactura mapeoFactura;

    @SqlStatement(namespace= "factura", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace = "factura", value = "listarPorIdUsuario")
    private static String sqlListarPorIdUsuario;

    public DaoFacturaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoFactura mapeoFactura) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoFactura = mapeoFactura;
    }

    @Override
    public List<DtoFactura> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, mapeoFactura);
    }

    @Override
    public List<DtoFactura> listarPorIdUsuario(Long idUsuario){
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idUsuario", idUsuario);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorIdUsuario, paramSource, mapeoFactura);
    }
}
