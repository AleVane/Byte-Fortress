package mx.edu.uacm.is.slt.ds.vitalpet.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import mx.edu.uacm.is.slt.ds.vitalpet.models.*;
import mx.edu.uacm.is.slt.ds.vitalpet.facades.VeterinariaFacade;

public class PersonaController {

    @FXML private TextField txtNombre, txtApellidos, txtEdad;
    @FXML private TextField txtCalle, txtNumero, txtCiudad, txtCodigoPostal, txtAlcaldia, txtTelefono;
    @FXML private Label lblMessage;

    private final VeterinariaFacade facade = new VeterinariaFacade();

    @FXML
    private void handleGuardar() {
        try {
            Direccion direccion = new Direccion();
            direccion.setCalle(txtCalle.getText());
            direccion.setNumero(txtNumero.getText());
            direccion.setCiudad(txtCiudad.getText());
            direccion.setCodigoPostal(txtCodigoPostal.getText());
            direccion.setAlcaldia(txtAlcaldia.getText());
            direccion.setTelefono(txtTelefono.getText());

            Persona persona = new Persona();
            persona.setNombre(txtNombre.getText());
            persona.setApellidos(txtApellidos.getText());
            persona.setEdad(Integer.parseInt(txtEdad.getText()));

            if (facade.registrarNuevoCliente(persona, null, direccion)) {
                lblMessage.setText("Cliente registrado exitosamente");
                lblMessage.setStyle("-fx-text-fill: green;");

                // ✅ Redirigir a mascota.fxml
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/mascota.fxml"));
                Stage stage = (Stage) txtNombre.getScene().getWindow();
                stage.setScene(new Scene(root, 700, 500));
                stage.show();

            } else {
                lblMessage.setText("Error al registrar cliente");
                lblMessage.setStyle("-fx-text-fill: red;");
            }

        } catch (NumberFormatException e) {
            lblMessage.setText("La edad debe ser un número válido");
            lblMessage.setStyle("-fx-text-fill: red;");
        } catch (Exception e) {
            lblMessage.setText("Error al cargar vista de mascota");
            lblMessage.setStyle("-fx-text-fill: red;");
            e.printStackTrace();
        }
    }

    @FXML
    private void handleLimpiar() {
        txtNombre.clear();
        txtApellidos.clear();
        txtEdad.clear();
        txtCalle.clear();
        txtNumero.clear();
        txtCiudad.clear();
        txtCodigoPostal.clear();
        txtAlcaldia.clear();
        txtTelefono.clear();
        lblMessage.setText("");
    }

    @FXML
    private void handleSalir() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
            Stage stage = (Stage) txtNombre.getScene().getWindow();
            stage.setScene(new Scene(root, 1000, 700));
            stage.show();
        } catch (Exception e) {
            lblMessage.setText("Error al regresar al menú principal");
            lblMessage.setStyle("-fx-text-fill: red;");
            e.printStackTrace();
        }
    }
}