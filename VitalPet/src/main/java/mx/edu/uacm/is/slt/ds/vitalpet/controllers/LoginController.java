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

public class LoginController {
    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtPassword;
    @FXML private CheckBox chkRemember;
    @FXML private Hyperlink linkForgot;
    @FXML private Button btnLogin;
    @FXML private Hyperlink linkRegistro;
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
        
        btnLogin.setOnAction(e -> handleLogin());
        linkRegistro.setOnAction(e -> handleIrARegistro());
    }

    private void handleLogin() {
        String username = txtUsuario.getText();
        String password = txtPassword.getText();
        
        //Usuario y Contraseña para entrar...
        if ("123".equals(username) && "123".equals(password)) {
            try {
                Persona persona = new Persona();
                persona.setNombre("Administrador");
                persona.setApellidos("Sistema");

                Usuario usuario = new Usuario();
                usuario.setUsername(username);
                usuario.setContrasena(password);
                persona.setUsuario(usuario);

                Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
                Stage stage = (Stage) btnLogin.getScene().getWindow();
                //stage.setScene(new Scene(root, 400, 500));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setWidth(600);
                stage.setHeight(500);
                stage.setResizable(true);
                stage.show();
            } catch (Exception e) {
                mostrarAlerta("Error", "No se pudo cargar la aplicación");
            }
        } else {
            mostrarAlerta("Error", "Usuario o contraseña incorrectos");
        }
    }

    @FXML
    private void handleIrARegistro() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/registro.fxml"));
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.setScene(new Scene(root, 400, 500));
            stage.show();
        } catch (Exception e) {
            mostrarAlerta("Error", "No se pudo cargar el formulario de registro");
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}