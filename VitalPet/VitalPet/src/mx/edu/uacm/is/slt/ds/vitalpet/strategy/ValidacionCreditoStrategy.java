package mx.edu.uacm.is.slt.ds.vitalpet.strategy;


public class ValidacionCreditoStrategy implements ValidacionTarjetaStrategy {
    @Override
    public boolean validar(String numeroTarjeta, String codigoSeguridad, String fechaExpiracion) {
        return numeroTarjeta != null && numeroTarjeta.length() == 16 
               && codigoSeguridad != null && codigoSeguridad.length() == 3
               && fechaExpiracion != null && fechaExpiracion.matches("(0[1-9]|1[0-2])/[0-9]{2}");
    }
}