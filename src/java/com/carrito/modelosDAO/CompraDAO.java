

package com.carrito.modelosDAO;

import com.carrito.config.Conexion;
import com.carrito.modelos.Carrito;
import com.carrito.modelos.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CompraDAO {
    
    Connection con;
        Conexion cn = new Conexion();
        PreparedStatement ps;
        ResultSet rs;
        int r = 0;
        
    public int GenerarCompra(Compra compra){
        int idcompras;
        String sql = "insert into tbcompras(IdCliente, IdPago, FechaCompras, Monto, Estado) values (?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, compra.getIdCliente().getIdCliente());
            ps.setInt(2, compra.getIdPago());
            ps.setString(3, compra.getFechaCompras());
            ps.setDouble(4, compra.getMonto());
            ps.setString(5, compra.getEstado());
            ps.executeUpdate();
            
            sql = "Select @@IDENTITY AS IdCompras";
            rs = ps.executeQuery(sql);
            rs.next();
            idcompras = rs.getInt("IdCompras");
            rs.close();
            
            for (Carrito detalle : compra.getDetallecompras()) {
                sql="insert into tbdetalle_compras(IdProducto ,IdCompras ,Cantidad,PrecioCompra)values(?,?,?,?)";
                ps=con.prepareStatement(sql);
                ps.setInt(1, detalle.getIdProducto());
                ps.setInt(2, idcompras);
                ps.setInt(3, detalle.getCantidad());
                ps.setDouble(4, detalle.getPrecioCompra());
                r = ps.executeUpdate();
            }
            
        } catch (Exception e) {
        
        }
        
        
        return r;
    }


 }

