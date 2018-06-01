package lu.dmi.icesi.studio;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.constraint.solver.widgets.Snapshot;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Carpeta extends AppCompatActivity {

    ExpandableListAdapterr listAdapter;
    ExpandableListView expListView;

    ImageButton botonCat, carpetas, calendario, playlist, admcuenta;

    FirebaseDatabase database;
    DatabaseReference referenceArch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carpeta);

        botonCat = findViewById(R.id.agregararchivoacarpeta);

        database = FirebaseDatabase.getInstance();
        referenceArch = database.getReference("Archivos");

        carpetas = findViewById(R.id.files);
        carpetas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Carpeta.this,Carpeta.class);
                startActivity(intent);
            }
        });
        calendario= findViewById(R.id.calendar);
        calendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Carpeta.this,Calendario.class);
                startActivity(intent);
            }
        });
        playlist = findViewById(R.id.music);
        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Carpeta.this,PlayLists.class);
                startActivity(intent);
            }
        });
        admcuenta = findViewById(R.id.persona);
        admcuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Carpeta.this,Admcuenta.class);
                startActivity(intent);
            }
        });

        /*
            Actualiza los datos segun firebase-database
         */
        referenceArch.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listAdapter.reiniciar();

                for(DataSnapshot d: dataSnapshot.getChildren()){
                ModeloArchivo modeloArchivo = d.getValue(ModeloArchivo.class);
                String titulo = modeloArchivo.getTitulo();
                String id = modeloArchivo.getId();
                List<String> list = modeloArchivo.getList();
              //  listDataChild.put(titulo, list);
                listAdapter.addItem(titulo, list, id);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        expListView = (ExpandableListView) findViewById(R.id.archivosdecarpeta);
        listAdapter = new ExpandableListAdapterr(this);
        expListView.setAdapter(listAdapter);


/*
    Agregar una nueva categoria
 */
        botonCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                // Creating alert Dialog with one Button
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Carpeta.this);
                alertDialog.setTitle("Agrega una categoria");
                alertDialog.setMessage("Genera una nueva categoria");

                final EditText input = new EditText(Carpeta.this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alertDialog.setView(input);

                // Boton Agregar
                alertDialog.setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int which) {
                                String titulo = input.getText().toString();
                                    if (titulo.equals("")) {
                                        Toast.makeText(getApplicationContext(), "Agregue un titulo", Toast.LENGTH_SHORT).show();
                                    } else {
                                        List<String> list = new ArrayList<>();
                                        addCategoria(input.getText().toString(),list);
                                    }
                                }
                });

                // Boton Cancelar
                alertDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Write your code here to execute after dialog
                                dialog.cancel();
                            }
                        });

                alertDialog.show();
            }
        });

        /*
            click en un archivo
         */
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, final int groupPosition, int childPosition, long id) {

                if(listAdapter.get_listDataChild().get(listAdapter.get_listDataHeader().get(groupPosition)).get(
                        childPosition).equals("Agregue Un Archivo")){

                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(Carpeta.this);
                    alertDialog.setTitle("Agrega un Archivo");
                    alertDialog.setMessage("cualquiera");

                    final EditText input = new EditText(Carpeta.this);
                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.MATCH_PARENT);
                    input.setLayoutParams(lp);
                    alertDialog.setView(input);

                    // Boton Agregar
                    alertDialog.setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int which) {
                            String titulo = input.getText().toString();
                            if (titulo.equals("")) {
                                Toast.makeText(getApplicationContext(), "Agregue un titulo", Toast.LENGTH_SHORT).show();
                            } else {
                                String id = listAdapter.get_listIds().get(groupPosition);

                                HashMap<String, List<String>> _listDataChild = listAdapter.get_listDataChild();
                                List<String> old = _listDataChild.get(listAdapter.get_listDataHeader().get(groupPosition));

                                List<String> act = _listDataChild.get(listAdapter.get_listDataHeader().get(groupPosition));

                                act.add(input.getText().toString());

                                listAdapter.addact(listAdapter.get_listDataHeader().get(groupPosition),old,act);

                                ModeloArchivo m = new ModeloArchivo(listAdapter.get_listDataHeader().get(groupPosition),act);
                                m.setId(id);
                                DatabaseReference ref = database.getReference("Archivos").child(id);
                                ref.setValue(m);

                            }
                        }
                    });

                    // Boton Cancelar
                    alertDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Write your code here to execute after dialog
                            dialog.cancel();
                        }
                    });

                    alertDialog.show();
                }

                Toast.makeText(getApplicationContext(), listAdapter.get_listDataHeader().get(groupPosition)
                                + " : "
                                + listAdapter.get_listDataChild().get(listAdapter.get_listDataHeader().get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }

    public void addCategoria( String titulo, List<String> lisft){
        if(lisft.size()==0){
            lisft.add("Agregue Un Archivo");
        }
        ModeloArchivo m = new ModeloArchivo(titulo, lisft);
        String id = referenceArch.push().getKey();
        m.setId(id);
        DatabaseReference ref = database.getReference("Archivos").child(id);
        ref.setValue(m);
    }

}
