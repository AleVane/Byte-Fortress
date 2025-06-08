package mx.edu.uacm.is.slt.ds.vitalpet.models;

public interface Tarjeta {
    boolean validarTarjeta();
    String getNumero();
    String getCodigoSeguridad();
    String getFechaExpiracion();
}