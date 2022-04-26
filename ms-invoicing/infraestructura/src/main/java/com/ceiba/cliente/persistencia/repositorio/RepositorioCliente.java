package com.ceiba.cliente.persistencia.repositorio;

import com.ceiba.cliente.modelo.entities.Cliente;
import com.ceiba.cliente.modelo.excepciones.ExcepcionTecnica;
import com.ceiba.cliente.modelo.excepciones.enums.EnumMensajeExcepcion;
import com.ceiba.cliente.puerto.dao.IDaoCliente;
import com.ceiba.cliente.puerto.repositorio.IRepositorioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.ceiba.cliente.modelo.excepciones.enums.EnumMensajeExcepcion.NO_ENCONTRADO;

@Repository
public class RepositorioCliente implements IDaoCliente {

    public static final String CLIENTE_ELIMINADO_CORRECTAMENTE = "Cliente eliminado correctamente.";
    @Autowired
    private IRepositorioCliente repositorioCliente;


    @Override
    public Cliente registrar(Cliente cliente) {
        return repositorioCliente.save(cliente);
    }

    @Override
    public Optional<Cliente> buscarPorId(String identificacion) {
        return repositorioCliente.findById(identificacion);
    }

    @Override
    public String eliminar(String identificacion) {
        try{
            repositorioCliente.deleteById(identificacion);
            return CLIENTE_ELIMINADO_CORRECTAMENTE;
        }catch(Exception e){
            throw new ExcepcionTecnica(e,NO_ENCONTRADO);
        }

    }

    @Override
    public List<Cliente> listar() {
        return repositorioCliente.listar();
    }
}
