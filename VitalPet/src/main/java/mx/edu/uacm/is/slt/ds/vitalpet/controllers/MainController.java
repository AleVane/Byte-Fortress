package mx.edu.uacm.is.slt.ds.vitalpet.controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import mx.edu.uacm.is.slt.ds.vitalpet.managers.VeterinariaManager;
import mx.edu.uacm.is.slt.ds.vitalpet.models.Persona;

public class MainController {
    @FXML private StackPane contentArea;
    @FXML private Label lblStatus;
    @FXML
    public void initialize() {
        // ← Mejora: proteger contra null y mostrar nombre completo
        Persona usuario = VeterinariaManager.getInstance().getUsuarioActual();
        if (usuario != null) {
            lblStatus.setText("Usuario: " + usuario.getNombre() + " " + usuario.getApellidos());
        } else {
            lblStatus.setText("Usuario: Desconocido");
        }
    }

    @FXML
    private void handleClientes() {
        loadView("/views/persona.fxml");
    }
    
    @FXML
    private void handleMascotas() {
        loadView("/views/mascota.fxml");
    }
    
    @FXML
    private void handleCitas() {
        loadView("/views/cita.fxml");
    }
    
    @FXML
    private void handlePagos() {
        loadView("/views/tarjeta.fxml");
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}