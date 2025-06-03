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
<<<<<<< HEAD
        loadView("/fxml/persona.fxml");
=======
        loadView("/views/persona.fxml");
>>>>>>> 46a124d49d8d4cb95b1c4e0d5dd1aab1db6642e8
    }
    
    @FXML
    private void handleMascotas() {
<<<<<<< HEAD
        loadView("/fxml/mascota.fxml");
=======
        loadView("/views/mascota.fxml");
>>>>>>> 46a124d49d8d4cb95b1c4e0d5dd1aab1db6642e8
    }
    
    @FXML
    private void handleCitas() {
<<<<<<< HEAD
        loadView("/fxml/cita.fxml");
=======
        loadView("/views/cita.fxml");
>>>>>>> 46a124d49d8d4cb95b1c4e0d5dd1aab1db6642e8
    }
    
    @FXML
    private void handlePagos() {
<<<<<<< HEAD
        loadView("/fxml/tarjeta.fxml");
=======
        loadView("/views/tarjeta.fxml");
>>>>>>> 46a124d49d8d4cb95b1c4e0d5dd1aab1db6642e8
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