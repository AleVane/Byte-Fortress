package mx.edu.uacm.is.slt.ds.vitalpet.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class FarmaciaController {

    @FXML private ComboBox<Integer> comboIvermectina;
    @FXML private ComboBox<Integer> comboRimadyl;
    @FXML private ComboBox<Integer> comboFrontline;

    @FXML
    public void initialize() {
        // Rellenar ComboBoxes con cantidades posibles (0 a 10)
        for (int i = 0; i <= 10; i++) {
            comboIvermectina.getItems().add(i);
            comboRimadyl.getItems().add(i);
            comboFrontline.getItems().add(i);
        }

        // Seleccionar valor por defecto 0
        comboIvermectina.setValue(0);
        comboRimadyl.setValue(0);
        comboFrontline.setValue(0);
    }

    @FXML
    private void handleGuardar() {
        int cantidadIvermectina = comboIvermectina.getValue();
        int cantidadRimadyl = comboRimadyl.getValue();
        int cantidadFrontline = comboFrontline.getValue();

        int total = (cantidadIvermectina * 235) +
                    (cantidadRimadyl * 448) +
                    (cantidadFrontline * 580);

        // Mostrar total en ventana emergente
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Resumen de Compra");
        alert.setHeaderText("Gracias por su compra");
        alert.setContentText("Total a pagar: $" + total + " MXN");
        alert.showAndWait();
    }

    @FXML
    private void handleSalir() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 1000, 700));
            stage.setTitle("Menú Principal");
            stage.show();

            // Cerrar ventana actual
            Stage actualStage = (Stage) comboIvermectina.getScene().getWindow();
            actualStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
