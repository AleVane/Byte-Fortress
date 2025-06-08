package mx.edu.uacm.is.slt.ds.vitalpet.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mx.edu.uacm.is.slt.ds.vitalpet.models.*;
import mx.edu.uacm.is.slt.ds.vitalpet.facades.VeterinariaFacade;

public class PersonaController {
    @FXML private TextField txtNombre, txtApellidos, txtEdad;
    @FXML private TextField txtCalle, txtNumero, txtCodigoPostal, txtDelegacion, txtMunicipio;
    @FXML private Label lblMessage;
    
    private final VeterinariaFacade facade = new VeterinariaFacade();
    
    @FXML
    private void handleGuardar() {
        try {
            Direccion direccion = new Direccion();
            direccion.setCalle(txtCalle.getText());
            direccion.setNumero(txtNumero.getText());
            direccion.setCodigoPostal(txtCodigoPostal.getText());
            direccion.setDelegacion(txtDelegacion.getText());
            direccion.setMunicipio(txtMunicipio.getText());
            
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
            lblMessage.setText("La edad debe ser un número válido");
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
        txtCodigoPostal.clear();
        txtDelegacion.clear();
        txtMunicipio.clear();
        lblMessage.setText("");
    }
}