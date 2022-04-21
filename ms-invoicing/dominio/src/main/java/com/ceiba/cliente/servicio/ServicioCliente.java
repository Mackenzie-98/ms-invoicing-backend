package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entities.Cliente;
import com.ceiba.cliente.puerto.dao.iDaoCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioCliente {

    public static final String CLIENTE_ELIMINADO = "El cliente con identificacion %s fue eliminado exitosamente.";
    public static final String CLIENTE_NO_ENCONTRADO = "Cliente no encontrado.";
    @Autowired
    private iDaoCliente daoCliente;

    public ResponseEntity<Cliente> registrarCliente(Cliente cliente){
        return new ResponseEntity(daoCliente.registrar(cliente), HttpStatus.OK);
    }

    public ResponseEntity<Cliente> buscarClientePorId(String identificacion){
        Optional<Cliente> busqueda = daoCliente.buscarPorId(identificacion);
        if(busqueda.isPresent())
            return new ResponseEntity(busqueda.get(),HttpStatus.OK);
        else
            return new ResponseEntity(CLIENTE_NO_ENCONTRADO,HttpStatus.NOT_FOUND);

    }
    public ResponseEntity<List<Cliente>> listarClientes(){
        return new ResponseEntity(daoCliente.listar(), HttpStatus.OK);
    }

    public ResponseEntity<String> eliminarCliente(String identificacion){
        daoCliente.eliminar(identificacion);
        return new ResponseEntity(String.format(CLIENTE_ELIMINADO, identificacion), HttpStatus.OK);
    }
}
