package mx.edu.uacm.is.slt.ds.vitalpet.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import mx.edu.uacm.is.slt.ds.vitalpet.models.Mascota;

public class MascotaController {

    @FXML private TextField txtNombre, txtEdad, txtColor, txtRaza;
    @FXML private ComboBox<String> cbSexo, cbEdad;
    @FXML private Label lblMessage;

    @FXML
    public void initialize() {
        cbSexo.getItems().addAll("Macho", "Hembra");
        cbEdad.getItems().addAll("Meses", "Años");
    }

    @FXML
    private void handleGuardar() {
        try {
            if (txtNombre.getText().isBlank() || txtEdad.getText().isBlank() ||
                txtColor.getText().isBlank() || txtRaza.getText().isBlank() ||
                cbSexo.getValue() == null || cbEdad.getValue() == null) {

                lblMessage.setText("Por favor completa todos los campos.");
                lblMessage.setStyle("-fx-text-fill: red;");
                return;
            }

            // Crear la mascota (solo como ejemplo si usarás modelo)
            Mascota mascota = new Mascota();
            mascota.setNombre(txtNombre.getText());
            mascota.setEdad(Integer.parseInt(txtEdad.getText()));
            mascota.setColor(txtColor.getText());
            mascota.setRaza(txtRaza.getText());
            mascota.setSexo(cbSexo.getValue());

            // Mensaje de éxito
            lblMessage.setText("Mascota registrada. Redirigiendo a pago...");
            lblMessage.setStyle("-fx-text-fill: green;");

            // Redirigir a ventana de pago
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/tarjeta.fxml"));
            Stage stage = (Stage) txtNombre.getScene().getWindow();
            stage.setScene(new Scene(root, 700, 500));
            stage.show();

        } catch (NumberFormatException e) {
            lblMessage.setText("Edad debe ser un número válido.");
            lblMessage.setStyle("-fx-text-fill: red;");
        } catch (Exception e) {
            lblMessage.setText("Error al redirigir a pago.");
            lblMessage.setStyle("-fx-text-fill: red;");
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSalir() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
            Stage stage = (Stage) txtNombre.getScene().getWindow();
            stage.setScene(new Scene(root, 1000, 700));
            stage.show();
        } catch (Exception e) {
            lblMessage.setText("No se pudo regresar al menú principal");
            lblMessage.setStyle("-fx-text-fill: red;");
            e.printStackTrace();
        }
    }

    @FXML
    private void handleLimpiar() {
        txtNombre.clear();
        txtEdad.clear();
        txtColor.clear();
        txtRaza.clear();
        cbSexo.setValue(null);
        cbEdad.setValue(null);
        lblMessage.setText("");
    }
}