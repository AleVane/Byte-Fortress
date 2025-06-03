package mx.edu.uacm.is.slt.ds.vitalpet.models;


import mx.edu.uacm.is.slt.ds.vitalpet.strategy.ValidacionDebitoStrategy;

public class TarjetaDebito implements Tarjeta {
    private String numero;
    private String codigoSeguridad;
    private String fechaExpiracion;
    private ValidacionDebitoStrategy estrategiaValidacion;

    public TarjetaDebito() {
        this.estrategiaValidacion = new ValidacionDebitoStrategy();
    }

    @Override
    public boolean validarTarjeta() {
        return estrategiaValidacion.validar(numero, codigoSeguridad, fechaExpiracion);
    }

    // Getters y Setters
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    
    public String getCodigoSeguridad() { return codigoSeguridad; }
    public void setCodigoSeguridad(String codigoSeguridad) { this.codigoSeguridad = codigoSeguridad; }
    
    public String getFechaExpiracion() { return fechaExpiracion; }
    public void setFechaExpiracion(String fechaExpiracion) { this.fechaExpiracion = fechaExpiracion; }
}