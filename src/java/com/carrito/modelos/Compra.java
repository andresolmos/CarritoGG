
package com.carrito.modelos;

import java.util.List;


public class Compra {
    private int IdCompras;
    private Cliente IdCliente;
    private int IdPago;
    private String FechaCompras;
    private Double Monto;
    private String Estado;
    
    private List<Carrito>detallecompras;

    public Compra() {
    }

    public Compra(Cliente IdCliente, int IdPago, String FechaCompras, Double Monto, String Estado, List<Carrito> detallecompras) {
        this.IdCliente = IdCliente;
        this.IdPago = IdPago;
        this.FechaCompras = FechaCompras;
        this.Monto = Monto;
        this.Estado = Estado;
        this.detallecompras = detallecompras;
    }

    public int getIdCompras() {
        return IdCompras;
    }

    public void setIdCompras(int IdCompras) {
        this.IdCompras = IdCompras;
    }

    public Cliente getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(Cliente IdCliente) {
        this.IdCliente = IdCliente;
    }

    public int getIdPago() {
        return IdPago;
    }

    public void setIdPago(int IdPago) {
        this.IdPago = IdPago;
    }

    public String getFechaCompras() {
        return FechaCompras;
    }

    public void setFechaCompras(String FechaCompras) {
        this.FechaCompras = FechaCompras;
    }

    public Double getMonto() {
        return Monto;
    }

    public void setMonto(Double Monto) {
        this.Monto = Monto;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public List<Carrito> getDetallecompras() {
        return detallecompras;
    }

    public void setDetallecompras(List<Carrito> detallecompras) {
        this.detallecompras = detallecompras;
    }
    
    
}
