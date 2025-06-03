package mx.edu.uacm.is.slt.ds.vitalpet.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import mx.edu.uacm.is.slt.ds.vitalpet.models.*;

public class TarjetaController {
    @FXML private TextField txtNumeroTarjeta, txtCodigoSeguridad, txtFechaExpiracion;
    @FXML private ComboBox<String> cbTipoTarjeta;
    @FXML private Spinner<Integer> spMesesSinIntereses;
    @FXML private Label lblMessage;
    
    @FXML
    public void initialize() {
        cbTipoTarjeta.getItems().addAll("Cr�dito", "D�bito");
        spMesesSinIntereses.setValueFactory(
            new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 24, 1));
    }
    
    @FXML
    private void handleValidarTarjeta() {
        Tarjeta tarjeta;
        
        if ("Cr�dito".equals(cbTipoTarjeta.getValue())) {
            tarjeta = (Tarjeta) new TarjetaCredito();
            ((TarjetaCredito) tarjeta).setMesesSinIntereses(spMesesSinIntereses.getValue());
        } else {
            tarjeta = (Tarjeta) new TarjetaDebito();
        }
        
        ((TarjetaCredito) tarjeta).setNumero(txtNumeroTarjeta.getText());
        ((TarjetaCredito) tarjeta).setCodigoSeguridad(txtCodigoSeguridad.getText());
        ((TarjetaCredito) tarjeta).setFechaExpiracion(txtFechaExpiracion.getText());
        
        if (tarjeta.validarTarjeta()) {
            lblMessage.setText("Tarjeta v�lida");
            lblMessage.setStyle("-fx-text-fill: green;");
        } else {
            lblMessage.setText("Tarjeta inv�lida");
            lblMessage.setStyle("-fx-text-fill: red;");
        }
    }
}