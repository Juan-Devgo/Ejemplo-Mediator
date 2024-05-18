package uniquindio.patrones.comportamentales.mediator.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MediatorConcreto implements Mediator{
    private Usuario usuarioEnLinea;
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
        setUsuarioEnLinea(usuario);
        usuarios.add(usuario);
    }
   
    // metodo para buscar un usuario 
    public Optional<Usuario> buscarUsuario(String nombre){
       Optional<Usuario> usuarioEncontrado = Optional.empty();
        for (Usuario usuario : usuarios){
            if (usuario.getNombre().equals(nombre)){
                usuarioEncontrado = Optional.of(usuario);
            }
        }
        return usuarioEncontrado;
    }

    //Getters
    public Usuario getUsuarioEnLinea() {
        return usuarioEnLinea;
    }public List<Usuario> getUsuarios() {
        return usuarios;
    }

    //Set Usuario En Línea
    public void setUsuarioEnLinea(Usuario usuarioEnLinea) {
        this.usuarioEnLinea = usuarioEnLinea;
    }

}