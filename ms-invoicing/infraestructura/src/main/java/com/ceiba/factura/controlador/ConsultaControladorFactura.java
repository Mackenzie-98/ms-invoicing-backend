package com.ceiba.factura.controlador;

import com.ceiba.factura.consulta.ManejadorListarFacturas;
import com.ceiba.factura.consulta.ManejadorListarFacturasPorUsuario;
import com.ceiba.factura.modelo.dto.DtoFactura;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/facturas")
@Api(tags={"Controlador consulta facturas"})
public class ConsultaControladorFactura {

    private final ManejadorListarFacturas manejadorListarFacturas;
    private final ManejadorListarFacturasPorUsuario manejadorListarFacturasPorUsuario;

    public ConsultaControladorFactura(ManejadorListarFacturas manejadorListarFacturas, ManejadorListarFacturasPorUsuario manejadorListarFacturasPorUsuario) {
        this.manejadorListarFacturas = manejadorListarFacturas;
        this.manejadorListarFacturasPorUsuario = manejadorListarFacturasPorUsuario;
    }

    @GetMapping
    @ApiOperation("Listar Facturas")
    public List<DtoFactura> listar() {
        return this.manejadorListarFacturas.ejecutar();
    }

    @GetMapping("/usuario/{idUsuario}")
    @ApiOperation("Listar Facturas por usuario")
    public List<DtoFactura> listarPorUsuario(@PathVariable Long idUsuario) {
        return this.manejadorListarFacturasPorUsuario.ejecutar(idUsuario);
    }

}
