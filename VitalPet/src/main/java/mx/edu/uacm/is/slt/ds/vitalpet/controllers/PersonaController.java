package mx.edu.uacm.is.slt.ds.vitalpet.controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mx.edu.uacm.is.slt.ds.vitalpet.models.*;
import mx.edu.uacm.is.slt.ds.vitalpet.facades.VeterinariaFacade;

public class PersonaController {
	@FXML private AnchorPane contentArea;
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
            } else {
                lblMessage.setText("Error al registrar cliente");
                lblMessage.setStyle("-fx-text-fill: red;");
            }
        } catch (NumberFormatException e) {
            lblMessage.setText("La edad debe ser un numero valido");
            lblMessage.setStyle("-fx-text-fill: red;");
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
    
    // Botón Salir
    @FXML
    private void handleSalir() {
        Stage stage = (Stage) contentArea.getScene().getWindow();
        stage.close();
    }

    // Método reutilizable para cargar vistas en contentArea
    private void loadView(String fxmlPath) {
        try {
            Parent view = FXMLLoader.load(getClass().getResource(fxmlPath));
            contentArea.getChildren().clear();
            contentArea.getChildren().add(view);
            AnchorPane.setTopAnchor(view, 0.0);
            AnchorPane.setRightAnchor(view, 0.0);
            AnchorPane.setBottomAnchor(view, 0.0);
            AnchorPane.setLeftAnchor(view, 0.0);
        } catch (Exception e) {
            System.out.println("Error al cargar vista: " + fxmlPath);
            e.printStackTrace();
        }
    }
}