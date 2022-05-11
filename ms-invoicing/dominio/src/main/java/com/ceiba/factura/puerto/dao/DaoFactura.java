package com.ceiba.factura.puerto.dao;

import com.ceiba.factura.modelo.dto.DtoFactura;

import java.util.List;

public interface DaoFactura {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoFactura> listar();

    List<DtoFactura> listarPorIdUsuario(Long idUsuario);
}
