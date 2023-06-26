package Modelos;

import java.util.List;

public class Cliente {
    private String idCliente;
    private String nombre;
    private String apellido;
    private String dni;
    private TipoContacto preferenciaContacto;
    private String telefono;
    private String email;
    private String calle;
    private String barrio;
    private String provincia;
    private String codigoPostal;
    private String pais;
    private List<Reserva> reservas;

    public Cliente(String idCliente, String nombre, String apellido, String dni, TipoContacto preferenciaContacto,
                   String telefono, String email, String calle, String barrio, String provincia,
                   String codigoPostal, String pais, List<Reserva> reservas) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.preferenciaContacto = preferenciaContacto;
        this.telefono = telefono;
        this.email = email;
        this.calle = calle;
        this.barrio = barrio;
        this.provincia = provincia;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
        this.reservas = reservas;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public TipoContacto getPreferenciaContacto() {
        return preferenciaContacto;
    }

    public void setPreferenciaContacto(TipoContacto preferenciaContacto) {
        this.preferenciaContacto = preferenciaContacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public EstrategiaContacto obtenerMetodoContacto() {
        TipoContacto tipoContacto = this.getPreferenciaContacto();
        EstrategiaContacto metodoContacto;

        switch (tipoContacto) {
            case SMS:
                metodoContacto = new SMS(this.getTelefono());
                break;
            case WHATSAPP:
                metodoContacto = new Whatsapp(this.getTelefono());
                break;
            case MAIL:
                metodoContacto = new Email(this.getEmail());
                break;
            default:
                metodoContacto = null;
        }

        return metodoContacto;
    }
}
