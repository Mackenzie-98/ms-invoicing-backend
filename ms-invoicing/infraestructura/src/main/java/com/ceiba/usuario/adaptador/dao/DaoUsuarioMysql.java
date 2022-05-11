package com.ceiba.usuario.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.puerto.dao.DaoUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;


@Component
public class DaoUsuarioMysql implements DaoUsuario {
    @Autowired
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @Autowired
    private final MapeoUsuario mapeoUsuario;

    @SqlStatement(namespace= "usuario", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace= "usuario", value="buscarPorId")
    private static String sqlBuscarPorId;

    public DaoUsuarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoUsuario mapeoUsuario) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoUsuario = mapeoUsuario;
    }

    @Override
    public List<DtoUsuario> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, mapeoUsuario);
    }
    @Override
    public DtoUsuario buscarPorId(Long id){
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlBuscarPorId, paramSource,mapeoUsuario).get(0);
    }
}
