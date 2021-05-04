
package com.carrito.controlador;

import com.carrito.modelos.Carrito;
import com.carrito.modelos.Producto;
import com.carrito.modelos.ProductoDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;


public class ControladorImplements {

    public static void actualizarCantidad(int idProducto, int cant, List<Carrito> listaCarrito) {
        for (int j = 0; j < listaCarrito.size(); j++) {
            if (listaCarrito.get(j).getIdProducto() == idProducto) {
                listaCarrito.get(j).setCantidad(cant);
                listaCarrito.get(j).setSubTotal(listaCarrito.get(j).getPrecioCompra() * cant);
            }
        }
    }

    public static void eliminarProducto(int IdProducto, List<Carrito> listaCarrito) {
        if (listaCarrito != null) {
            for (int j = 0; j < listaCarrito.size(); j++) {
                if (listaCarrito.get(j).getIdProducto() == IdProducto) {
                    listaCarrito.remove(j);
                }
            }
        }
    }

    

    public static void response(String url, String message, String alert,HttpServletRequest request) {
        request.setAttribute("URL", url);
        request.setAttribute("mensaje", message);
        request.setAttribute("alert", alert);
    }
}
