package mx.edu.uacm.is.slt.ds.vitalpet.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mx.edu.uacm.is.slt.ds.vitalpet.managers.VeterinariaManager;
import mx.edu.uacm.is.slt.ds.vitalpet.models.Persona;

public class MainController {

    @FXML private AnchorPane contentArea;
    @FXML private Label lblStatus;
    @FXML private ImageView imgPrinci;

    @FXML
    public void initialize() {
        // Mostrar el nombre del usuario actual si está disponible
        Persona usuario = VeterinariaManager.getInstance().getUsuarioActual();
        if (usuario != null) {
            lblStatus.setText("Usuario: " + usuario.getNombre() + " " + usuario.getApellidos());
        } else {
            lblStatus.setText("Usuario: Desconocido");
        }

        // Cargar imagen del logo/avatar
        try {
            Image img = new Image(getClass().getResource("/img/avatar.png").toExternalForm());
            imgPrinci.setImage(img);
        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen: /img/avatar.png");
            e.printStackTrace();
        }
    }

    // Botón Clientes
    @FXML
    private void handleClientes() {
        loadView("/fxml/persona.fxml");
    }

    // Botón Mascotas
    @FXML
    private void handleMascotas() {
        loadView("/fxml/mascota.fxml");
    }

    // Botón Citas
    @FXML
    private void handleCitas() {
        loadView("/fxml/cita.fxml");
    }

    // Botón Pagos
    @FXML
    private void handlePagos() {
        loadView("/fxml/tarjeta.fxml");
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