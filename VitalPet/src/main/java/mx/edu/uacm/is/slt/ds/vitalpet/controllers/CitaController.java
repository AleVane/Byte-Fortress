package mx.edu.uacm.is.slt.ds.vitalpet.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import mx.edu.uacm.is.slt.ds.vitalpet.models.Cita;
import mx.edu.uacm.is.slt.ds.vitalpet.models.Mascota;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class CitaController {

    @FXML private DatePicker dpFecha;
    @FXML private TextField txtMotivo;
    @FXML private ComboBox<String> cbHorario;
    @FXML private ComboBox<Mascota> cbMascota;
    @FXML private Label lblMessage;
    @FXML private ImageView imgBanner;

    @FXML
    public void initialize() {
        cbHorario.getItems().addAll("09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00");

        // Mascotas ficticias (puedes remplazar por datos reales si tienes DAO)
        cbMascota.getItems().addAll(
            new Mascota("Luna"),
            new Mascota("Firulais"),
            new Mascota("Milo")
        );

        try {
            Image img = new Image(getClass().getResource("/img/cita.png").toExternalForm());
            imgBanner.setImage(img);
        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen: /img/cita.png");
        }
    }

    @FXML
    private void handleAgendar() {
        try {
            if (dpFecha.getValue() == null || cbHorario.getValue() == null ||
                cbMascota.getValue() == null || txtMotivo.getText().isBlank()) {
                lblMessage.setText("Por favor, completa todos los campos");
                lblMessage.setStyle("-fx-text-fill: red;");
                return;
            }

            LocalTime hora = LocalTime.parse(cbHorario.getValue().trim());

            Cita cita = new Cita();
            cita.setFecha(LocalDateTime.of(dpFecha.getValue(), hora));
            cita.setMotivo(txtMotivo.getText());
            cita.setHorario(cbHorario.getValue());
            cita.setMascota(cbMascota.getValue());

            lblMessage.setText("Cita agendada exitosamente");
            lblMessage.setStyle("-fx-text-fill: green;");

            // Ir a pagos.fxml
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/tarjeta.fxml"));
            Stage stage = (Stage) dpFecha.getScene().getWindow();
            stage.setScene(new Scene(root, 700, 500));
            stage.show();

        } catch (Exception e) {
            lblMessage.setText("Error al agendar cita: " + e.getMessage());
            lblMessage.setStyle("-fx-text-fill: red;");
            e.printStackTrace();
        }
    }

    @FXML
    private void handleLimpiar() {
        dpFecha.setValue(null);
        cbHorario.setValue(null);
        cbMascota.setValue(null);
        txtMotivo.clear();
        lblMessage.setText("");
    }

    @FXML
    private void handleSalir() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
            Stage stage = (Stage) dpFecha.getScene().getWindow();
            stage.setScene(new Scene(root, 1000, 700));
            stage.show();
        } catch (Exception e) {
            lblMessage.setText("No se pudo regresar al menú principal");
            lblMessage.setStyle("-fx-text-fill: red;");
            e.printStackTrace();
        }
    }
}
