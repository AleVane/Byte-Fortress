package mx.edu.uacm.is.slt.ds.vitalpet.strategy;


public interface ValidacionTarjetaStrategy {
    boolean validar(String numeroTarjeta, String codigoSeguridad, String fechaExpiracion);
}
