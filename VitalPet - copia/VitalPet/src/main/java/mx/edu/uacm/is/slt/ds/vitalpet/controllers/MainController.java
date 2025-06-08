package mx.edu.uacm.is.slt.ds.vitalpet.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import mx.edu.uacm.is.slt.ds.vitalpet.managers.VeterinariaManager;
import mx.edu.uacm.is.slt.ds.vitalpet.models.Persona;

public class MainController {
    @FXML private AnchorPane contentArea; // Cambiado de StackPane a AnchorPane
    @FXML private Label lblStatus;
    
    @FXML
    public void initialize() {
        Persona usuario = VeterinariaManager.getInstance().getUsuarioActual();
        if (usuario != null) {
            lblStatus.setText("Usuario: " + usuario.getNombre() + " " + usuario.getApellidos());
        } else {
            lblStatus.setText("Usuario: Desconocido");
        }
    }

    @FXML
    private void handleClientes() {
        loadView("/fxml/persona.fxml");
    }
    
    @FXML
    private void handleMascotas() {
        loadView("/fxml/mascota.fxml");
    }
    
    @FXML
    private void handleCitas() {
        loadView("/fxml/cita.fxml");
    }
    
    @FXML
    private void handlePagos() {
        loadView("/fxml/tarjeta.fxml");
    }
    
    @FXML
    private void handleSalir() {
        System.exit(0);
    }
    
    private void loadView(String fxmlPath) {
        try {
            Parent view = FXMLLoader.load(getClass().getResource(fxmlPath));
            contentArea.getChildren().clear();
            contentArea.getChildren().add(view);
            // Ajustar el contenido para que ocupe todo el espacio del AnchorPane
            AnchorPane.setTopAnchor(view, 0.0);
            AnchorPane.setRightAnchor(view, 0.0);
            AnchorPane.setBottomAnchor(view, 0.0);
            AnchorPane.setLeftAnchor(view, 0.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}