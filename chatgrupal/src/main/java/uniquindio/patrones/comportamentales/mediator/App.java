package uniquindio.patrones.comportamentales.mediator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uniquindio.patrones.comportamentales.mediator.Model.*;

import java.io.IOException;
/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static MediatorConcreto mediator = new MediatorConcreto();

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("agregarUsuario"), 640, 480);
        stage.setTitle("Chat Grupal");
        stage.setScene(scene);
        stage.show();
    }

    public static void closeWindow() {
        Stage stage = (Stage) scene.getWindow();
        stage.close();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);

        MediatorConcreto mediator = new MediatorConcreto();
        Usuario usuario1 = new UsuarioConcreto("Pepito", "123", mediator);
        Usuario usuario2 = new UsuarioConcreto("Pepita", "321", mediator);
        Usuario usuario3 = new UsuarioConcreto("Angie", "301", mediator);

        mediator.agregarUsuario(usuario1); mediator.agregarUsuario(usuario2); mediator.agregarUsuario(usuario3);

        usuario1.enviarMensajeGlobal("HOLA A TODOSS");
        usuario2.enviarMensajePrivado("¿Qué le pasa a pepito?", usuario3);
    }

}