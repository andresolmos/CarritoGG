
package com.carrito.modelos;


public class Pago {
    private int IdPago;
    private Double Monto;

    public Pago() {
    }

    public Pago(int IdPago, Double Monto) {
        this.IdPago = IdPago;
        this.Monto = Monto;
    }

    public int getIdPago() {
        return IdPago;
    }

    public void setIdPago(int IdPago) {
        this.IdPago = IdPago;
    }

    public Double getMonto() {
        return Monto;
    }

    public void setMonto(Double Monto) {
        this.Monto = Monto;
    }

 
    
    
}
