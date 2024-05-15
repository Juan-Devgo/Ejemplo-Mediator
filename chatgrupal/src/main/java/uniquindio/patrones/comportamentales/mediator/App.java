package uniquindio.patrones.comportamentales.mediator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uniquindio.patrones.comportamentales.mediator.Model.MediatorConcreto;
import uniquindio.patrones.comportamentales.mediator.Model.Usuario;
import uniquindio.patrones.comportamentales.mediator.Model.UsuarioConcreto;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {

        MediatorConcreto mediator = new MediatorConcreto();
        Usuario usuario1 = new UsuarioConcreto("Pepito", "123", mediator);
        Usuario usuario2 = new UsuarioConcreto("Pepita", "321", mediator);
        Usuario usuario3 = new UsuarioConcreto("Angie", "301", mediator);
        mediator.agregarUsuario(usuario1); mediator.agregarUsuario(usuario2); mediator.agregarUsuario(usuario3);

        usuario1.enviarMensajeGlobal("HOLA A TODOSS");
        usuario2.enviarMensajePrivado("¿Qué le pasa a pepito?", usuario3);

    }

}