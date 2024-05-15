package uniquindio.patrones.comportamentales.mediator.Model;

import java.util.ArrayList;
import java.util.List;

public class MediatorConcreto implements Mediator{
    private List<Usuario> usuarios;

    public MediatorConcreto() {
        this.usuarios = new ArrayList<>();
    }

    @Override
    public void enviarMensaje(String mensaje, Usuario usuario) {
        assert mensaje != null;

        if(usuario == null) {
            enviarMensajeGlobal(mensaje);
        }else{
            enviarMensajePrivado(mensaje, usuario);
        }
    }

    // metodo para enviar un mensaje Global
    public void enviarMensajeGlobal(String mensaje){
        for (Usuario usuario : usuarios) {
                usuario.recibirMensaje(mensaje);
        }
    }

    // metodo para enviar mensaje Privado
    private void enviarMensajePrivado(String mensaje, Usuario usuario) {
        usuario.recibirMensaje(mensaje);
    }
    
    // metodo para agregar un usuario
    public void agregarUsuario(Usuario usuario) {
        assert usuario != null;
        usuarios.add(usuario);
    }
    // metodo para eliminiar un usuario
    public void eliminarUsuario(Usuario usuario){
        usuarios.remove(usuario); 
    }
    
}