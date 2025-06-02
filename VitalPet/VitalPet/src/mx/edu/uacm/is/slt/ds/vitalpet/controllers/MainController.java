package mx.edu.uacm.is.slt.ds.vitalpet.controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import mx.edu.uacm.is.slt.ds.vitalpet.managers.VeterinariaManager;

public class MainController {
    @FXML private StackPane contentArea;
    @FXML private Label lblStatus;
    
    @FXML
    public void initialize() {
        lblStatus.setText("Usuario: " + VeterinariaManager.getInstance().getUsuarioActual().getNombre());
    }
    
    @FXML
    private void handleClientes() {
        loadView("/com/veterinaria/views/persona.fxml");
    }
    
    @FXML
    private void handleMascotas() {
        loadView("/com/veterinaria/views/mascota.fxml");
    }
    
    @FXML
    private void handleCitas() {
        loadView("/com/veterinaria/views/cita.fxml");
    }
    
    @FXML
    private void handlePagos() {
        loadView("/com/veterinaria/views/tarjeta.fxml");
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