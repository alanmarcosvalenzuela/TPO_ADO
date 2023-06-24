package Modelos;

public class Notificacion {
    private String idNotificacion;
    private String mensaje;
    private EstrategiaContacto estrategiaContacto;

    public Notificacion(String idNotificacion, String mensaje, EstrategiaContacto estrategiaContacto) {
        this.idNotificacion = idNotificacion;
        this.mensaje = mensaje;
        this.estrategiaContacto = estrategiaContacto;
    }

    public String getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(String idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public EstrategiaContacto getEstrategiaContacto() {
        return estrategiaContacto;
    }

    public void setEstrategiaContacto(EstrategiaContacto estrategiaContacto) {
        this.estrategiaContacto = estrategiaContacto;
    }

    public void enviarNotificacion() {
        estrategiaContacto.enviarNotificacion(mensaje);
    }

    public void cambiarEstrategia(EstrategiaContacto estrategiaContacto) {
        this.estrategiaContacto = estrategiaContacto;
    }

}
