package mx.edu.uacm.is.slt.ds.vitalpet.models;

public class TarjetaDebito implements Tarjeta {

    private String numero;
    private String codigoSeguridad;
    private String fechaExpiracion;

    @Override
    public boolean validarTarjeta() {
        return numero != null && !numero.isBlank()
                && codigoSeguridad != null && codigoSeguridad.matches("\\d{3}")
                && fechaExpiracion != null && fechaExpiracion.matches("\\d{2}/\\d{2}");
    }

    @Override
    public String getNumero() {
        return numero;
    }

    @Override
    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    @Override
    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
}
