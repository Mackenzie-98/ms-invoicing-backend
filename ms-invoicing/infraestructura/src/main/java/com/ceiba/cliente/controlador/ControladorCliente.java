package com.ceiba.cliente.controlador;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.servicio.ServicioCliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@Api(tags = { "Controlador cliente"})
public class ControladorCliente {

    @Autowired
    private ServicioCliente servicioCliente;

    @PostMapping("/registrar")
    @ApiOperation("Registrar cliente")
    public ResponseEntity<DtoCliente> registrar(@RequestBody DtoCliente cliente){
        return servicioCliente.registrarCliente(cliente);
    }

    @GetMapping("buscar/{id}")
    public ResponseEntity buscar(@PathVariable String id){
        return servicioCliente.buscarClientePorId(id);
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable String id){
        return servicioCliente.eliminarCliente(id);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<DtoCliente>> listar(){
        return servicioCliente.listarClientes();
    }

    @PutMapping("/editar")
    public ResponseEntity<DtoCliente> editar(@RequestBody DtoCliente cliente){
        return servicioCliente.actualizarCliente(cliente);
    }

}
