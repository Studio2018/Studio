package lu.dmi.icesi.studio;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by estudiante on 31/05/18.
 */

public class Adaptadorfecha extends BaseAdapter {

    Activity activity;
    ArrayList<Evento> eventodeldia;
    ArrayList <Evento> eventos;
    TextView nombreevento, inicio, fin, fecha;
    ImageButton borrar;

    public Adaptadorfecha(Activity activity){
        this.activity = activity;
        eventodeldia = new ArrayList<Evento>();
        eventos = new ArrayList<Evento>();
        nombreevento = new TextView(activity);
    }


    @Override
    public int getCount() {
        return eventos.size();
    }

    @Override
    public Object getItem(int position) {
        return eventos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        LayoutInflater li = activity.getLayoutInflater();
        View ver = li.inflate(R.layout.fecharenglon,null);

        nombreevento = (TextView) ver.findViewById(R.id.nombredeentrega);
        inicio = (TextView) ver.findViewById(R.id.inicio);
        fin = (TextView) ver.findViewById(R.id.fin);
        fecha = (TextView) ver.findViewById(R.id.fechadeentrega);

        borrar = (ImageButton) ver.findViewById(R.id.removefgh);

        nombreevento.setText(eventos.get(i).getNombreevento());
        inicio.setText(eventos.get(i).getInicio());
        fin.setText(eventos.get(i).getFin());
        fecha.setText(eventos.get(i).getFecha());

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eventos.remove(eventos.get(i));
                notifyDataSetChanged();
            }
        });

        return ver;
    }

    public void addevento(Evento nuevo){
        eventos.add(nuevo);
        notifyDataSetChanged();
    }
}
