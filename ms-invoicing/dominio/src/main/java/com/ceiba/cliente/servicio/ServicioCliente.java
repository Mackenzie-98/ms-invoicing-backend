package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entities.Cliente;
import com.ceiba.cliente.modelo.excepciones.ExcepcionTecnica;
import com.ceiba.cliente.modelo.excepciones.enums.EnumMensajeExcepcion;
import com.ceiba.cliente.puerto.dao.IDaoCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

import static com.ceiba.cliente.modelo.excepciones.enums.EnumMensajeExcepcion.*;

@Service
@RequiredArgsConstructor
public class ServicioCliente {

    public static final String CLIENTE_ELIMINADO = "El cliente con identificacion %s fue eliminado exitosamente.";
    @Autowired
    private IDaoCliente daoCliente;

    public ResponseEntity<Cliente> registrarCliente(Cliente cliente){
        return new ResponseEntity(daoCliente.registrar(cliente), HttpStatus.OK);
    }

    public ResponseEntity<Cliente> buscarClientePorId(String identificacion){
        Optional<Cliente> busqueda = daoCliente.buscarPorId(identificacion);
        if(busqueda.isPresent())
            return new ResponseEntity(busqueda.get(),HttpStatus.OK);
        else
            throw new ExcepcionTecnica(NO_ENCONTRADO);

    }
    public ResponseEntity<List<Cliente>> listarClientes(){
        return new ResponseEntity(daoCliente.listar(), HttpStatus.OK);
    }

    public ResponseEntity<String> eliminarCliente(String identificacion){
        return new ResponseEntity(daoCliente.eliminar(identificacion), HttpStatus.OK);
    }
}
