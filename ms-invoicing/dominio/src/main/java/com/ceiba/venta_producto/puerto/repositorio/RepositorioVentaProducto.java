package com.ceiba.venta_producto.puerto.repositorio;

import com.ceiba.venta_producto.modelo.entidad.VentaProducto;

public interface RepositorioVentaProducto {
    /**
     * Permite crear una venta de un producto
     * @param ventaProducto
     * @return el id generado
     */
    Long crear(VentaProducto ventaProducto,Long idFactura);

    /**
     * Permite validar si existe un usuario con un nombre
     * @param nombre
     * @return si existe o no
     */

    /**
     * Permite validar si existe un usuario con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existePorId(Long id);

}
