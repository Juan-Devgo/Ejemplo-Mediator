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
import javafx.scene.layout.AnchorPane;
import uniquindio.patrones.comportamentales.mediator.App;
import uniquindio.patrones.comportamentales.mediator.Model.*;

public class PrincipalController {

    @FXML
    private AnchorPane Usuario;

    @FXML
    private Button botonAgregarUsuario;

    @FXML
    private Button botonEnviar;

    @FXML
    private Button botonLogIn;

    @FXML
    private Label consola;

    @FXML
    private Label nombreUsuario;

    @FXML
    private TextField txMensaje;

    @FXML
    private TextField txReceptores;

    private MediatorConcreto mediator;
    

    private Usuario usuarioLoggeado;

    @FXML
    void initialize() {
        this.mediator = App.mediator;
        obtenerUsuarioLoggeado();
        mostrarUsuarioLoggeado();
    }

    @FXML
    private void mostrarUsuarioLoggeado() {
        String nombreUsuarioLoggeado = usuarioLoggeado.getNombre();
        nombreUsuario.setText("Usuario en línea: " + nombreUsuarioLoggeado);
    }

    @FXML
    public void cambiarLogIn(ActionEvent event) throws IOException {
        App.setRoot("loggin");
    }

    @FXML
    public void cambiarAgregarUsuario(ActionEvent event) throws IOException {
        App.setRoot("agregarUsuario");
    }

    @FXML
    public void enviarMensaje(ActionEvent event) {
        String receptor = txReceptores.getText();
        String mensaje = txMensaje.getText();

        if(receptor.isBlank()){
            usuarioLoggeado.enviarMensajeGlobal(mensaje);
        }else{
            if (buscarUsuario(receptor)){
                Usuario destinatario = mediator.buscarUsuario(receptor).get();
                usuarioLoggeado.enviarMensajePrivado(mensaje, destinatario);

            }else{
                consola.setText("El usuario no se encontró.");
            }
        }
        consola.setText(usuarioLoggeado.mostrarConversacionPantalla());
        txMensaje.setText("");
    }

    private void obtenerUsuarioLoggeado(){
        this.usuarioLoggeado = mediator.getUsuarioEnLinea();
    }

    private boolean buscarUsuario(String nombre) {
        Optional<Usuario> usuarioEncontrado = mediator.buscarUsuario(nombre);
        return usuarioEncontrado.isPresent();      
    }
}