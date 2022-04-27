package com.ceiba.cliente.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cliente.ComandoCliente;
import com.ceiba.cliente.manejador.ManejadorRegistrarCliente;
import com.ceiba.cliente.modelo.entities.Cliente;
import com.ceiba.cliente.servicio.ServicioCliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@Api(tags = { "Controlador cliente"})
public class ControladorCliente {

    private final ServicioCliente servicioCliente;

    public ControladorCliente(ServicioCliente servicioCliente) {
        this.servicioCliente = servicioCliente;
    }

    @PostMapping("/registrar")
    @ApiOperation("Registrar cliente")
    public ResponseEntity<Cliente> registrar(@RequestBody Cliente cliente){
        return servicioCliente.registrarCliente(cliente);
    }

    @GetMapping("buscar/{id}")
    @ApiOperation("Buscar cliente por id")
    public ResponseEntity buscar(@PathVariable String id){
        return servicioCliente.buscarClientePorId(id);
    }

    @DeleteMapping("eliminar/{id}")
    @ApiOperation("Eliminar cliente por id")
    public ResponseEntity<String> eliminar(@PathVariable String id){
        return servicioCliente.eliminarCliente(id);
    }

    @GetMapping("/listar")
    @ApiOperation("Listar todos los clientes")
    public ResponseEntity<List<Cliente>> listar(){
        return servicioCliente.listarClientes();
    }
}