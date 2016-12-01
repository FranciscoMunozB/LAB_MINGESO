/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import model.Productos;
import java.util.List;
import javax.ejb.Local;
/**
 *
 * @author Buging
 */
public interface ProductoLocal {

    void addProducto(Productos producto);

    void editProducto(Productos producto);

    void deleteProducto(int productoId);

    Productos getProducto(int productoId);

    List<Productos> getAllProductos();
    
}
