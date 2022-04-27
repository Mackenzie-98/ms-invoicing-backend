package com.ceiba.cliente.manejador;

import com.ceiba.cliente.ComandoCliente;
import com.ceiba.ComandoRespuesta;
import com.ceiba.cliente.fabrica.FabricaCliente;
import com.ceiba.cliente.modelo.entities.Cliente;
import com.ceiba.cliente.servicio.ServicioCliente;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorRegistrarCliente implements ManejadorComandoRespuesta<ComandoCliente, ComandoRespuesta> {

    private final ServicioCliente servicioCliente;
    private final FabricaCliente fabricaCliente;

    public ManejadorRegistrarCliente(ServicioCliente servicioCliente, FabricaCliente fabricaCliente) {
        this.servicioCliente = servicioCliente;
        this.fabricaCliente = fabricaCliente;
    }

    @Override
    public ComandoRespuesta ejecutar(ComandoCliente comandoCliente) {
        Cliente cliente = this.fabricaCliente.crear(comandoCliente);
        return new ComandoRespuesta(this.servicioCliente.registrarCliente(cliente));
    }
}
