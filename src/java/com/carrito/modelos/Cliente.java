

package com.carrito.modelos;


public class Cliente {
    private int IdCliente;
    private String Identificacion;
    private String Nombres;
    private String Direccion;
    private String Email;
    private String Password;

    public Cliente() {
    }

    public Cliente(int IdCliente, String Identificacion, String Nombres, String Direccion, String Email, String Password) {
        this.IdCliente = IdCliente;
        this.Identificacion = Identificacion;
        this.Nombres = Nombres;
        this.Direccion = Direccion;
        this.Email = Email;
        this.Password = Password;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(String Identificacion) {
        this.Identificacion = Identificacion;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
}
