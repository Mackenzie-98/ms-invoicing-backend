package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.dto.response.DtoVerDetalleFactura;
import com.ceiba.cliente.modelo.entities.Cliente;
import com.ceiba.cliente.modelo.entities.DetalleFactura;
import com.ceiba.cliente.modelo.entities.Factura;
import com.ceiba.cliente.puerto.dao.iDaoCliente;
import com.ceiba.cliente.puerto.dao.iDaoDetalleFactura;
import com.ceiba.cliente.puerto.dao.iDaoFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioDetalleFactura {

    @Autowired
    private iDaoDetalleFactura daoDetalleFactura;

    @Autowired
    private iDaoFactura daoFactura;


    public ResponseEntity<DtoVerDetalleFactura> verDetalleFactura(int id){
        DtoVerDetalleFactura detalleFactura = new DtoVerDetalleFactura();

        Factura factura = daoFactura.buscarPorId(id).get();
        Cliente cliente = factura.getCliente();

        detalleFactura.setFactura(factura);
        detalleFactura.setCliente(cliente);
        detalleFactura.setDetalleCompras(daoDetalleFactura.verDetalleFactura(id));
        detalleFactura.setTotal(calcularTotalFactura(factura.getDetalleFacturas()));

        return new ResponseEntity(detalleFactura,HttpStatus.OK);
    }

    private float calcularTotalFactura(List<DetalleFactura> detalleFactura){
        float total = 0;
        for (int i = 0; i < detalleFactura.size(); i++) {
            float costo = detalleFactura.get(i).getProducto().getPrecioUnitario();
            int cantidad = detalleFactura.get(i).getCantidad();
            total += costo*cantidad;
        }
        return total;
    }

}
