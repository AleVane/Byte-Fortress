package mx.edu.uacm.is.slt.ds.vitalpet.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    @FXML
    private void initialize() {
        try {
            Image avatar = new Image(getClass().getResource("/img/avatar.png").toExternalForm());
            avatarImagen.setImage(avatar);

            // Asociar acción al botón
            loginBoton.setOnAction(e -> handleLogin());

        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen del avatar.");
            e.printStackTrace();
        }
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
