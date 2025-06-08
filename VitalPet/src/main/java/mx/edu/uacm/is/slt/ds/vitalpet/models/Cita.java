package mx.edu.uacm.is.slt.ds.vitalpet.models;


import java.time.LocalDateTime;

public class Cita {
    private int idCita;
    private LocalDateTime fecha;
    private String motivo;
    private String horario;
    private Mascota mascota;

    // Getters y Setters
    public int getIdCita() { return idCita; }
    public void setIdCita(int idCita) { this.idCita = idCita; }
    
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    
    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    
    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }
    
    public Mascota getMascota() { return mascota; }
    public void setMascota(Mascota mascota) { this.mascota = mascota; }
}