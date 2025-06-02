package mx.edu.uacm.is.slt.ds.vitalpet.strategy;


public class ValidacionDebitoStrategy implements ValidacionTarjetaStrategy {
    @Override
    public boolean validar(String numeroTarjeta, String codigoSeguridad, String fechaExpiracion) {
        return numeroTarjeta != null && numeroTarjeta.length() >= 13 
               && codigoSeguridad != null && (codigoSeguridad.length() == 3 || codigoSeguridad.length() == 4)
               && fechaExpiracion != null && fechaExpiracion.matches("(0[1-9]|1[0-2])/[0-9]{2}");
    }
}