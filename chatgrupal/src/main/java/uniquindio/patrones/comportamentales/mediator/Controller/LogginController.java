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

public class LogginController {

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

    private MediatorConcreto mediator;

    @FXML
    void initialize() {
        this.mediator = App.mediator;
    }

    @FXML
    private void cambiarInicial(ActionEvent event) throws IOException {
        if(mediator.getUsuarios().isEmpty()){
            App.closeWindow();
        }else{
            App.setRoot("principal");
        }
    }

    @FXML
    public void loggear(ActionEvent event) throws IOException {
        String nombreUsuario = txUsuario.getText();

        if(buscarUsuario(nombreUsuario)){
            Usuario usuario = mediator.buscarUsuario(nombreUsuario).get();
            mediator.setUsuarioEnLinea(usuario);
            App.setRoot("principal");
        }else{
            consola.setText("El usuario no se encontró.");
        }
    }

    private boolean buscarUsuario(String nombre) {
        Optional<Usuario> usuarioEncontrado = mediator.buscarUsuario(nombre);
        return usuarioEncontrado.isPresent();      
    }
}