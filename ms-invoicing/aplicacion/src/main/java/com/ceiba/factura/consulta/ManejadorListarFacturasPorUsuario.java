package com.ceiba.factura.consulta;

import com.ceiba.factura.modelo.dto.DtoFactura;
import com.ceiba.factura.puerto.dao.DaoFactura;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarFacturasPorUsuario {

    private final DaoFactura daoFactura;

    public ManejadorListarFacturasPorUsuario(DaoFactura daoFactura){
        this.daoFactura = daoFactura;
    }

    public List<DtoFactura> ejecutar(Long idUsuario){ return this.daoFactura.listarPorIdUsuario(idUsuario); }
}
