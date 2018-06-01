package lu.dmi.icesi.studio;

import java.util.List;

/**
 * Created by estudiante on 29/05/18.
 */

public class ModeloArchivo {

    private String id;
    private String titulo;
    private List<String> list;

    public ModeloArchivo(){

    }

    public ModeloArchivo(String titulo, List<String> list){
        this.titulo=titulo;
        this.list=list;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
