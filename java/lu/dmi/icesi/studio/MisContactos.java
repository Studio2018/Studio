package lu.dmi.icesi.studio;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.List;

public class MisContactos extends AppCompatActivity {

    ImageButton añadir;
    ListView contactos;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    ArrayList<Usuario> amigos;

    ImageButton carpetas, calendario, playlist, admcuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_contactos);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Contactos");

        amigos = new ArrayList<Usuario>();


        contactos = (ListView) findViewById(R.id.grupos);
            añadir = (ImageButton) findViewById(R.id.añadir);
            final Activity activity = this;
            añadir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //activar la camara para leer códigos qr

                    addUser("miNombre", "micorreo");

                    IntentIntegrator integrator = new IntentIntegrator(activity);
                    integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                    integrator.setPrompt("Scan");
                    integrator.setCameraId(0);
                    integrator.setBeepEnabled(false);
                    integrator.setBarcodeImageEnabled(false);
                    integrator.initiateScan();
                }
            });

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                amigos = new ArrayList<Usuario>();
                for(DataSnapshot d: dataSnapshot.getChildren()){
                    Usuario u = d.getValue(Usuario.class);
                    String nombre = u.getNombre();
                    String id = u.getId();
                    //List<String> list = modeloArchivo.getList();
                   amigos.add(u);

                   System.out.println("odwuihediwuehdiwuhediuwehdiwehiduwehdiweudiuwehdi      "+amigos.size());
                    //listAdapter.addItem(titulo, list, id);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        carpetas = findViewById(R.id.files);
        carpetas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MisContactos.this,Carpeta.class);
                startActivity(intent);
            }
        });
        calendario= findViewById(R.id.calendar);
        calendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MisContactos.this,Calendario.class);
                startActivity(intent);
            }
        });
        playlist = findViewById(R.id.music);
        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MisContactos.this,PlayLists.class);
                startActivity(intent);
            }
        });
        admcuenta = findViewById(R.id.persona);
        admcuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MisContactos.this,Admcuenta.class);
                startActivity(intent);            }
        });

    }

        @Override
        protected void  onActivityResult(int requestCode, int resultCode, Intent data){
            IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
            if (result != null){
                if (result.getContents()==null){
                    Toast.makeText(this, "Has cancelado el escanner", Toast.LENGTH_LONG).show();
                }else {
                    ArrayList<String> list = new ArrayList<>();
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
                    contactos.setAdapter(adapter);

                    list.add("Pepito Perez \nA00032123");
                    Toast.makeText(this,result.getContents(),Toast.LENGTH_LONG).show();

                }
            }else {

                super.onActivityResult(requestCode,resultCode,data);
            }
        }

    public void addUser( String email, String contrasena){
        Usuario u = new Usuario(email, contrasena);
        String id = databaseReference.push().getKey();
        u.setId(id);
        DatabaseReference ref = databaseReference.child(id);
        ref.setValue(u);
    }
    }

