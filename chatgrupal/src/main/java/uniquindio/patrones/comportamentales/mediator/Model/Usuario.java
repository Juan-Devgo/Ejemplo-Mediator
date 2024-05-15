package uniquindio.patrones.comportamentales.mediator.Model;

public abstract class Usuario {
    private String nombre, codigo;

    public Usuario(String nombre, String codigo) {
        assert nombre != null && !nombre.isBlank();
        assert codigo != null && !nombre.isBlank();
    }
    
    public abstract void enviarMensajeGlobal(String mensaje);
    public abstract void enviarMensajePrivado(String mensaje, Usuario usuario);
    
    // adaptar metodo a javafx por fis 
    public void recibirMensaje(String mensaje){
        System.out.println();
    }

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
