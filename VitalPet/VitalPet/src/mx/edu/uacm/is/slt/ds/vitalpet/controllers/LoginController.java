package mx.edu.uacm.is.slt.ds.vitalpet.controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mx.edu.uacm.is.slt.ds.vitalpet.managers.VeterinariaManager;
import mx.edu.uacm.is.slt.ds.vitalpet.models.Usuario;
import mx.edu.uacm.is.slt.ds.vitalpet.models.Persona;

public class LoginController {
    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblMessage;
    
    @FXML
    private void handleLogin() {
        String username = txtUsername.getText();
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
                
                Parent root = FXMLLoader.load(getClass().getResource("/com/veterinaria/views/main.fxml"));
                Stage stage = (Stage) txtUsername.getScene().getWindow();
                stage.setScene(new Scene(root, 800, 600));
                stage.show();
            } catch (Exception e) {
                lblMessage.setText("Error al cargar la aplicación");
                e.printStackTrace();
            }
        } else {
            lblMessage.setText("Usuario o contraseña incorrectos");
        }
    }
}
