package uniquindio.patrones.comportamentales.mediator.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import uniquindio.patrones.comportamentales.mediator.App;
import uniquindio.patrones.comportamentales.mediator.Model.*;

public class AgregarUsuarioController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button botonAceptar;

    @FXML
    private Button botonVolver;

    @FXML
    private Label consola;

    @FXML
    private TextField txUsuario;

    @FXML
    private TextField txCodigo;

    private MediatorConcreto mediator;

    @FXML
    void initialize() {
        this.mediator = App.mediator;
    }
 
    @FXML
    void agregarUsuario(ActionEvent event) throws IOException {
        String nombreUsuario = txUsuario.getText();
        String codigoUsuario = txCodigo.getText();

        if (!buscarUsuario(nombreUsuario)){
            Usuario usuario = crearUsuario(nombreUsuario, codigoUsuario, mediator);
            mediator.agregarUsuario(usuario);
            App.setRoot("principal");
        }else{
            consola.setText("El usuario ya existe.");
        }
    }

    @FXML
    void cambiarInicial(ActionEvent event) throws IOException {
        App.setRoot("principal");
    }

    private boolean buscarUsuario(String nombre) {
        Optional<Usuario> usuarioEncontrado = mediator.buscarUsuario(nombre);
        return usuarioEncontrado.isPresent();      
    }

    private Usuario crearUsuario(String nombre, String codigo, Mediator mediator) {
        Usuario usuarioConcreto = new UsuarioConcreto(nombre, codigo, mediator);
        return usuarioConcreto;
    }
}