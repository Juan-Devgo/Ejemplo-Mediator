package uniquindio.patrones.comportamentales.mediator.Model;

public class UsuarioConcreto extends Usuario {
    private Mediator mediator;

    public UsuarioConcreto(String nombre, String codigo, Mediator mediator){
       super(nombre, codigo);
       assert mediator != null;

       this.mediator = mediator;
    }

    @Override
    public void enviarMensajeGlobal(String mensaje) {
        assert mensaje != null;
        mediator.enviarMensaje(mensaje, this);
    }

    @Override
    public void enviarMensajePrivado(String mensaje, Usuario usuario) {
        assert mensaje != null;
        mediator.enviarMensaje(mensaje, usuario);
    }
}
