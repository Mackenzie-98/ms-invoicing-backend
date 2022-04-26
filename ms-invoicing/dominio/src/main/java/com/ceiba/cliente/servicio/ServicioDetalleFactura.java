package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.dto.response.DtoVerDetalleFactura;
import com.ceiba.cliente.modelo.entities.DetalleFactura;
import com.ceiba.cliente.modelo.entities.Factura;
import com.ceiba.cliente.modelo.excepciones.ExcepcionTecnica;
import com.ceiba.cliente.modelo.excepciones.enums.EnumMensajeExcepcion;
import com.ceiba.cliente.puerto.dao.IDaoDetalleFactura;
import com.ceiba.cliente.puerto.dao.IDaoFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.ceiba.cliente.modelo.excepciones.enums.EnumMensajeExcepcion.NO_ENCONTRADO;

@Service
public class ServicioDetalleFactura {

    @Autowired
    private IDaoDetalleFactura daoDetalleFactura;

    @Autowired
    private IDaoFactura daoFactura;


    public ResponseEntity<DtoVerDetalleFactura> verDetalleFactura(int id){
        DtoVerDetalleFactura detalleFactura = new DtoVerDetalleFactura();

        Optional<Factura> factura = daoFactura.buscarPorId(id);
        if(factura.isPresent()){
            detalleFactura.setFactura(factura.get());
            detalleFactura.setDetalleCompras(daoDetalleFactura.verDetalleFactura(id));
            detalleFactura.setTotal(calcularTotalFactura(factura.get().getDetalleFacturas()));
            return new ResponseEntity(detalleFactura,HttpStatus.OK);
        }else
            throw new ExcepcionTecnica(NO_ENCONTRADO);
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
