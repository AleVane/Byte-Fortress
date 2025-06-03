package mx.edu.uacm.is.slt.ds.vitalpet.models;


public class Direccion {
    private String calle;
    private String numero;
    private String codigoPostal;
    private String delegacion;
    private String municipio;

    // Getters y Setters
    public String getCalle() { return calle; }
    public void setCalle(String calle) { this.calle = calle; }
    
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    
    public String getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }
    
    public String getDelegacion() { return delegacion; }
    public void setDelegacion(String delegacion) { this.delegacion = delegacion; }
    
    public String getMunicipio() { return municipio; }
    public void setMunicipio(String municipio) { this.municipio = municipio; }
}