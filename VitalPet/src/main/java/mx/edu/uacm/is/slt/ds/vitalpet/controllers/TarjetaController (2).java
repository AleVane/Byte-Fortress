package mx.edu.uacm.is.slt.ds.vitalpet.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import mx.edu.uacm.is.slt.ds.vitalpet.models.*;

public class TarjetaController {

    @FXML private ComboBox<String> cbTipoTarjeta;
    @FXML private TextField txtNumeroTarjeta;
    @FXML private TextField txtCodigoSeguridad;
    @FXML private TextField txtFechaExpiracion;
    @FXML private Spinner<Integer> spMesesSinIntereses;
    @FXML private Label lblMessage;
    @FXML private ImageView imgTarjeta;

    @FXML
    public void initialize() {
        cbTipoTarjeta.getItems().addAll("Crédito", "Débito");

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 24, 0);
        spMesesSinIntereses.setValueFactory(valueFactory);
        spMesesSinIntereses.setVisible(false);  // Oculto por default

        cbTipoTarjeta.setOnAction(e -> {
            boolean esCredito = "Crédito".equals(cbTipoTarjeta.getValue());
            spMesesSinIntereses.setVisible(esCredito);
        });

        try {
            Image img = new Image(getClass().getResource("/img/tarjeta.png").toExternalForm());
            imgTarjeta.setImage(img);
        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen: /img/tarjeta.png");
            e.printStackTrace();
        }
    }
    
    @FXML
    private void handleValidarTarjeta() {
        String tipo = cbTipoTarjeta.getValue();
        String numero = txtNumeroTarjeta.getText();
        String codigo = txtCodigoSeguridad.getText();
        String fecha = txtFechaExpiracion.getText();

        if (tipo == null || numero.isBlank() || codigo.isBlank() || fecha.isBlank()) {
            lblMessage.setText("Por favor completa todos los campos.");
            lblMessage.setStyle("-fx-text-fill: red;");
            return;
        }

        Tarjeta tarjeta;

        if (tipo.equals("Crédito")) {
            TarjetaCredito credito = new TarjetaCredito();
            credito.setNumero(numero);
            credito.setCodigoSeguridad(codigo);
            credito.setFechaExpiracion(fecha);
            credito.setMesesSinIntereses(spMesesSinIntereses.getValue());
            tarjeta = credito;
        } else {
            TarjetaDebito debito = new TarjetaDebito();
            debito.setNumero(numero);
            debito.setCodigoSeguridad(codigo);
            debito.setFechaExpiracion(fecha);
            tarjeta = debito;
        }

        if (tarjeta.validarTarjeta()) {
            lblMessage.setText("Pago Efectuado");
            lblMessage.setStyle("-fx-text-fill: green;");
        } else {
            lblMessage.setText("Datos inválidos o incompletos.");
            lblMessage.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    private void handleLimpiar() {
        cbTipoTarjeta.setValue(null);
        txtNumeroTarjeta.clear();
        txtCodigoSeguridad.clear();
        txtFechaExpiracion.clear();
        spMesesSinIntereses.getValueFactory().setValue(0);
        spMesesSinIntereses.setVisible(false);
        lblMessage.setText("");
    }

    @FXML
    private void handleSalir() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/mascota.fxml"));
            Stage stage = (Stage) cbTipoTarjeta.getScene().getWindow();
            stage.setScene(new Scene(root, 1000, 700));
            stage.show();
        } catch (Exception e) {
            lblMessage.setText("Error al regresar al menú principal");
            lblMessage.setStyle("-fx-text-fill: red;");
            e.printStackTrace();
        }
    }

    @FXML
    private void handleEfectivo() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/efectivo.fxml"));
            Stage stage = (Stage) cbTipoTarjeta.getScene().getWindow();
            stage.setScene(new Scene(root, 700, 500));
            stage.show();
        } catch (Exception e) {
            lblMessage.setText("No se pudo abrir la vista de pago en efectivo");
            lblMessage.setStyle("-fx-text-fill: red;");
            e.printStackTrace();
        }
    }
}
    