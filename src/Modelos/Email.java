package Modelos;

public class Email implements EstrategiaContacto{

    private String mail;

    public Email(String mail) {
        this.mail = mail;
    }

    @Override
    public void enviarNotificacion(String mensaje) {
        // Lógica para enviar la notificación por email al correo especificado
        System.out.println("Enviando notificación por email a: " + mail);
    }
}
