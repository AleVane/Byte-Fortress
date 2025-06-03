package mx.edu.uacm.is.slt.ds.vitalpet.models;


import mx.edu.uacm.is.slt.ds.vitalpet.strategy.ValidacionCreditoStrategy;

public class TarjetaCredito implements Tarjeta {
    private int mesesSinIntereses;
    private String numero;
    private String codigoSeguridad;
    private String fechaExpiracion;
    private ValidacionCreditoStrategy estrategiaValidacion;

    public TarjetaCredito() {
        this.estrategiaValidacion = new ValidacionCreditoStrategy();
    }

    @Override
    public boolean validarTarjeta() {
        return estrategiaValidacion.validar(numero, codigoSeguridad, fechaExpiracion);
    }

    // Getters y Setters
    public int getMesesSinIntereses() { return mesesSinIntereses; }
    public void setMesesSinIntereses(int mesesSinIntereses) { this.mesesSinIntereses = mesesSinIntereses; }
    
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    
    public String getCodigoSeguridad() { return codigoSeguridad; }
    public void setCodigoSeguridad(String codigoSeguridad) { this.codigoSeguridad = codigoSeguridad; }
    
    public String getFechaExpiracion() { return fechaExpiracion; }
    public void setFechaExpiracion(String fechaExpiracion) { this.fechaExpiracion = fechaExpiracion; }
}