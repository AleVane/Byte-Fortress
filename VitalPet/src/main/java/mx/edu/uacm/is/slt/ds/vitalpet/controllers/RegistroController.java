package mx.edu.uacm.is.slt.ds.vitalpet.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import mx.edu.uacm.is.slt.ds.vitalpet.models.Persona;
import mx.edu.uacm.is.slt.ds.vitalpet.models.Usuario;

public class RegistroController {
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtContrasena;
    @FXML private Button btnRegistrar;
    @FXML private Button btnSalir;
    @FXML private ImageView imgAvatar;

    @FXML
    private void initialize() {
        try {
            // Cargar imagen de avatar
            Image avatar = new Image(getClass().getResource("/img/avatar.png").toExternalForm());
            imgAvatar.setImage(avatar);
            imgAvatar.setFitWidth(80);
            imgAvatar.setFitHeight(80);
            imgAvatar.setPreserveRatio(true);
        } catch (Exception e) {
            System.out.println("Error al cargar el avatar");
        }
        
        btnRegistrar.setOnAction(e -> handleRegistro());
        btnSalir.setOnAction(e -> volverALogin());
    }

    private void handleRegistro() {
        if (validarCampos()) {
            Persona persona = new Persona();
            persona.setNombre(txtNombre.getText());
            persona.setApellidos(txtApellido.getText());
            
            Usuario usuario = new Usuario();
            usuario.setUsername(txtUsuario.getText());
            usuario.setContrasena(txtContrasena.getText());
            persona.setUsuario(usuario);
            
            mostrarAlerta("Éxito", "Registro completado correctamente");
            volverALogin();
        }
    }

    private boolean validarCampos() {
        if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || 
            txtUsuario.getText().isEmpty() || txtContrasena.getText().isEmpty()) {
            mostrarAlerta("Error", "Todos los campos son obligatorios");
            return false;
        }
        
        if (txtContrasena.getText().length() < 8) {
            mostrarAlerta("Error", "La contraseña debe tener al menos 8 caracteres");
            return false;
        }
        
        return true;
    }

    private void volverALogin() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
            Stage stage = (Stage) btnRegistrar.getScene().getWindow();
            stage.setScene(new Scene(root, 400, 500));
            stage.show();
        } catch (Exception e) {
            mostrarAlerta("Error", "No se pudo regresar al login");
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}