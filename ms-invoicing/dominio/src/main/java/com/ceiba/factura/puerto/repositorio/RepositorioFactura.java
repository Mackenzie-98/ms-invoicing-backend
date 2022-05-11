package com.ceiba.factura.puerto.repositorio;

import com.ceiba.factura.modelo.entidad.Factura;

public interface RepositorioFactura {
    /**
     * Permite crear una factura
     * @param factura
     * @return el id generado
     */
    Long crear(Factura factura);

    /**
     * Permite eliminar una factura
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe una factura por id
     * @return si existe o no
     */
    boolean existePorId(Long id);

}
