
package com.carrito.controlador;

import com.carrito.config.Fecha;
import com.carrito.modelos.Carrito;
import com.carrito.modelos.Cliente;
import com.carrito.modelos.Compra;
import com.carrito.modelos.Pago;
import com.carrito.modelos.Producto;
import com.carrito.modelos.ProductoDAO;
import com.carrito.modelosDAO.CompraDAO;
import com.carrito.utils.Constants;
import com.carrito.utils.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Controlador extends HttpServlet {

    ProductoDAO pdao = new ProductoDAO();
    Producto p = new Producto();
    List <Producto> productos = new ArrayList<>();
    
    List<Carrito> listaCarrito = new ArrayList<>();
    int item;
    double totalPagar=0.0;
    int cantidad=1;
    
    int ipd;
    Carrito car = new Carrito();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        productos = pdao.ListarProductos();
        switch(accion){
            case "carrito":
                totalPagar = 0.0;
                request.setAttribute("Carrito", listaCarrito) ;
                for (int i = 0; i < listaCarrito.size(); i++) {
                    totalPagar = totalPagar + listaCarrito.get(i).getSubTotal();
                }
                request.setAttribute("totalPagar", totalPagar);
                Utils.distpatcherServlet(Constants.URL_CARRITO_INICIAL, request, response);
                break;
            case "AgregarCarrito":
                int pos = 0;
                cantidad = 1;
                ipd = Integer.parseInt(request.getParameter("IdProducto"));
                p = pdao.ListarId(ipd);
                if (listaCarrito.size() > 0){
                    for (int i = 0; i < listaCarrito.size(); i++){
                        if(ipd == listaCarrito.get(i).getIdProducto()){
                            pos = i;
                        }
                    }
                    if(ipd == listaCarrito.get(pos).getIdProducto()){
                        cantidad = listaCarrito.get(pos).getCantidad()+cantidad;
                        double subtotal = listaCarrito.get(pos).getPrecioCompra()*cantidad;
                        listaCarrito.get(pos).setCantidad(cantidad);
                        listaCarrito.get(pos).setSubTotal(subtotal);
                    }else{
                        item = item + 1;
                        car = new Carrito();
                        car.setItem(item);
                        car.setIdProducto(p.getIdProducto());
                        car.setNombres(p.getNombre());
                        car.setDescripcion(p.getDescripcion());
                        car.setPrecioCompra(p.getPrecio());
                        car.setCantidad(cantidad);
                        car.setSubTotal(cantidad*p.getPrecio());
                        listaCarrito.add(car);
                    }
                }else{
                    item = item + 1;
                    car = new Carrito();
                    car.setItem(item);
                    car.setIdProducto(p.getIdProducto());
                    car.setNombres(p.getNombre());
                    car.setDescripcion(p.getDescripcion());
                    car.setPrecioCompra(p.getPrecio());
                    car.setCantidad(cantidad);
                    car.setSubTotal(cantidad*p.getPrecio());
                    listaCarrito.add(car);
                }
                request.setAttribute("contador", listaCarrito.size());
                request.getRequestDispatcher("Controlador?accion=home").forward(request, response);
                break;
            case "deleteProducto":
                ControladorImplements.eliminarProducto(Integer.valueOf(request.getParameter("IdProducto")), listaCarrito);
                break;
            case "ActualizarCantidad":
                ControladorImplements.actualizarCantidad(
                        Integer.valueOf(request.getParameter("IdProducto")),
                        Integer.valueOf(request.getParameter("cantidad")),
                        listaCarrito);
                break;
            case "GenerarCompra":
                Cliente cliente = new Cliente();
                cliente.setIdCliente(1);
                CompraDAO dao = new CompraDAO();
                Compra compra = new Compra(cliente, 1, Fecha.FechaBD(), totalPagar, "Cancelado", listaCarrito);
                int res = dao.GenerarCompra(compra);
                if (res != 0 && totalPagar > 0) {
                    listaCarrito=new ArrayList<>();
                    ControladorImplements.response(Constants.URL_HOME, Constants.MESSAGE_SUCCESS, Constants.CONFIG_ALERT_SUCCESS, request);
                    Utils.distpatcherServlet(Constants.URL_MESSAGE, request, response);
                } else {
                    ControladorImplements.response(Constants.URL_HOME, Constants.MESSAGE_WARNING, Constants.CONFIG_ALERT_WARNING, request);
                    Utils.distpatcherServlet(Constants.URL_MESSAGE, request, response);
                }
                break;
            
            default:
                request.setAttribute("productos", productos);
                request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
