package uniquindio.patrones.comportamentales.mediator.Model;

public abstract class Usuario {
    private String nombre, codigo;

    public Usuario(String nombre, String codigo) {
        assert nombre != null && !nombre.isBlank();
        assert codigo != null && !codigo.isBlank();

        this.nombre = nombre;
        this.codigo = codigo;
    }
    
    public abstract void enviarMensajeGlobal(String mensaje);
    public abstract void enviarMensajePrivado(String mensaje, Usuario usuarioReceptor);
    public abstract void recibirMensaje(String mensaje);
    public abstract String mostrarConversacionPantalla();


    //Getters
    public String getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }
    
    //Setters
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
