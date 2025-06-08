package mx.edu.uacm.is.slt.ds.vitalpet.models;


public class Mascota {
    private int idMascota;
    private String nombre;
    private int edad;
    private String raza;
    private String color;
    private String sexo;

    public Mascota() {}

    public Mascota(String nombre) {
        this.nombre = nombre;
    }
    // Getters y Setters
    public int getIdMascota() { return idMascota; }
    public void setIdMascota(int idMascota) { this.idMascota = idMascota; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    
    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }
    
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    
    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }
    
    @Override
    public String toString() {
        return nombre;
    }

}