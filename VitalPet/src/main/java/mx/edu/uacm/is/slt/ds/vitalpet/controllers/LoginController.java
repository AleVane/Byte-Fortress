package mx.edu.uacm.is.slt.ds.vitalpet.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
<<<<<<< HEAD
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
=======
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import mx.edu.uacm.is.slt.ds.vitalpet.managers.VeterinariaManager;
import mx.edu.uacm.is.slt.ds.vitalpet.models.Usuario;
import mx.edu.uacm.is.slt.ds.vitalpet.models.Persona;

public class LoginController {

    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtPassword;
    @FXML private CheckBox chkRecordar;
    @FXML private Button loginBoton;
    @FXML private ImageView avatarImagen;
>>>>>>> 46a124d49d8d4cb95b1c4e0d5dd1aab1db6642e8

    @FXML
    private void initialize() {
        try {
<<<<<<< HEAD
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
=======
            Image avatar = new Image(getClass().getResource("/img/avatar.png").toExternalForm());
            avatarImagen.setImage(avatar);

            // Asociar acción al botón
            loginBoton.setOnAction(e -> handleLogin());

        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen del avatar.");
            e.printStackTrace();
        }
>>>>>>> 46a124d49d8d4cb95b1c4e0d5dd1aab1db6642e8
    }

    private void handleLogin() {
        String username = txtUsuario.getText();
        String password = txtPassword.getText();

        if ("admin".equals(username) && "admin123".equals(password)) {
            try {
                Persona persona = new Persona();
                persona.setNombre("Administrador");
                persona.setApellidos("Sistema");

                Usuario usuario = new Usuario();
                usuario.setUsername(username);
                usuario.setContrasena(password);
                persona.setUsuario(usuario);

<<<<<<< HEAD
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
                Stage stage = (Stage) btnLogin.getScene().getWindow();
                stage.setScene(new Scene(root, 400, 500));
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
=======
                VeterinariaManager.getInstance().setUsuarioActual(persona);

                Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
                Stage stage = (Stage) txtUsuario.getScene().getWindow();
                stage.setScene(new Scene(root, 800, 600));
                stage.show();
            } catch (Exception e) {
                System.out.println("Error al cargar la aplicación");
                e.printStackTrace();
            }
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
        }
    }
}
>>>>>>> 46a124d49d8d4cb95b1c4e0d5dd1aab1db6642e8
