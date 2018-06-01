package lu.dmi.icesi.studio;

public class Usuario {

    private String nombre, email, contrasena, confirmacion, id;

    public Usuario(){}

    public Usuario(String email, String contrasena){
        nombre = null;
        this.email = email;
        this.contrasena = contrasena;
        confirmacion = null;
        id = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
