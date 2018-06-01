package lu.dmi.icesi.studio;

/**
 * Created by estudiante on 31/05/18.
 */

public class Evento {

    private String fecha;
    private String nombreevento;
    private String inicio;
    private String fin;
    private String id;

    private String grupo;

    public Evento(){}

    public Evento (String fecha, String nombreevento, String inicio, String fin){
        this.fecha = fecha;
        this.nombreevento = nombreevento;
        this.inicio=inicio;
        this.fin = fin;
        id = null;
        grupo = null;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombreevento() {
        return nombreevento;
    }

    public void setNombreevento(String nombreevento) {
        this.nombreevento = nombreevento;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}
