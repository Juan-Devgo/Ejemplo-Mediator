package uniquindio.patrones.comportamentales.mediator.Model;

public class UsuarioConcreto extends Usuario {
    private String conversacion;
    private Mediator mediator;

    public UsuarioConcreto(String nombre, String codigo, Mediator mediator){
       super(nombre, codigo);
       assert mediator != null;

       this.conversacion = "";
       this.mediator = mediator;
    }

    @Override
    public void enviarMensajeGlobal(String mensaje) {
        assert mensaje != null;
        mensaje = getNombre() + ":\n" + mensaje;
        mediator.enviarMensaje(mensaje, null);
    }

    @Override
    public void enviarMensajePrivado(String mensaje, Usuario usuario) {
        assert mensaje != null;
        mensaje = getNombre() + ":\n" + mensaje;
        conversacion += "\n" + mensaje;
        mediator.enviarMensaje(mensaje, usuario);
    }

    //Recibe el mensaje, lo adiciona a su conversación 
    @Override
    public void recibirMensaje(String mensaje){
        conversacion += "\n" + mensaje;
        System.out.println(conversacion);
    }

    //Mostrar mensaje en pantalla junto con mensajes anteriores
    @Override
    public String mostrarConversacionPantalla(){
        return getConversacion();
    }

    //Getters
    public String getConversacion() {
        return conversacion;
    }

    //Setters
    public void setConversacion(String conversacion) {
        this.conversacion = conversacion;
    }
}
