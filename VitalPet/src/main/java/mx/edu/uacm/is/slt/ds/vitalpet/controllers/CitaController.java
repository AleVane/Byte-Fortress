package mx.edu.uacm.is.slt.ds.vitalpet.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDateTime;
import mx.edu.uacm.is.slt.ds.vitalpet.models.*;

public class CitaController {
    @FXML private DatePicker dpFecha;
    @FXML private TextField txtMotivo;
    @FXML private ComboBox<String> cbHorario;
    @FXML private ComboBox<Mascota> cbMascota;
    @FXML private Label lblMessage;
    
    @FXML
    public void initialize() {
        cbHorario.getItems().addAll("09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00");
        // Aquí deberías cargar las mascotas del usuario actual
    }
    
    @FXML
    private void handleAgendar() {
        try {
            Cita cita = new Cita();
            cita.setFecha(LocalDateTime.of(dpFecha.getValue(), 
                java.time.LocalTime.parse(cbHorario.getValue() + ":00")));
            cita.setMotivo(txtMotivo.getText());
            cita.setHorario(cbHorario.getValue());
            cita.setMascota(cbMascota.getValue());
            
            lblMessage.setText("Cita agendada exitosamente");
            lblMessage.setStyle("-fx-text-fill: green;");
        } catch (Exception e) {
            lblMessage.setText("Error al agendar cita");
            lblMessage.setStyle("-fx-text-fill: red;");
            e.printStackTrace();
        }
    }
}