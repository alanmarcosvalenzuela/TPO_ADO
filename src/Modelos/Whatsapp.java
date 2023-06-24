package Modelos;

public class Whatsapp implements EstrategiaContacto{
    private String numeroWPP;

    public Whatsapp(String numeroWPP) {
        this.numeroWPP = numeroWPP;
    }

    @Override
    public void enviarNotificacion(String mensaje) {
        // Lógica para enviar la notificación por WhatsApp al número especificado
        System.out.println("Enviando notificación por WhatsApp al número: " + numeroWPP);
    }
}
