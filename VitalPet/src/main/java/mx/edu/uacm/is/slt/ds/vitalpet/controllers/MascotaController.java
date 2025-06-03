package mx.edu.uacm.is.slt.ds.vitalpet.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import mx.edu.uacm.is.slt.ds.vitalpet.models.*;

public class MascotaController {
    @FXML private TextField txtNombre, txtEdad, txtRaza, txtColor;
    @FXML private ComboBox<String> cbSexo;
    @FXML private Label lblMessage;
    
    @FXML
    public void initialize() {
        cbSexo.getItems().addAll("Macho", "Hembra");
    }
    
    @FXML
    private void handleGuardar() {
        try {
            Mascota mascota = new Mascota();
            mascota.setNombre(txtNombre.getText());
            mascota.setEdad(Integer.parseInt(txtEdad.getText()));
            mascota.setRaza(txtRaza.getText());
            mascota.setColor(txtColor.getText());
            mascota.setSexo(cbSexo.getValue());
            
            lblMessage.setText("Mascota registrada exitosamente");
            lblMessage.setStyle("-fx-text-fill: green;");
        } catch (NumberFormatException e) {
            lblMessage.setText("La edad debe ser un número válido");
            lblMessage.setStyle("-fx-text-fill: red;");
        }
    }
}
