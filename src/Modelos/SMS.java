package Modelos;

public class SMS implements EstrategiaContacto{
    private String numeroSMS;

    public SMS(String numeroSMS) {
        this.numeroSMS = numeroSMS;
    }

    @Override
    public void enviarNotificacion(String mensaje) {
        // Lógica para enviar la notificación por SMS al número especificado
        System.out.println("Enviando notificación por SMS al número: " + numeroSMS);
    }
}
