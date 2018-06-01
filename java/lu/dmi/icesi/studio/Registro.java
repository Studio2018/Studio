package lu.dmi.icesi.studio;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registro extends AppCompatActivity {

    private EditText usuario, mail,contrasena, confirmarcion;
    private TextView u,m,c,cc,log;
    private Button registrar;

    private Typeface confortaB, confortaR, confortaT;


    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;

////////////////////////////////////////////////////////////////////////
    Logica logic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        if(firebaseAuth.getCurrentUser() != null){
            //Verifico si ya estoy logueado
            Intent i = new Intent(this, Main.class);
            startActivity(i);
            return;
        }

        ////////////////////////////////////////////////////////////////////////
        logic = new Logica();

        Thread thread = new Thread(logic);
        thread.start();



        String fuenteregular = "fuentes/Comfortaa_Regular.ttf";
        confortaR = Typeface.createFromAsset(getAssets(),fuenteregular);

        String fuentebold = "fuentes/Comfortaa_Bold.ttf";
        this.confortaB = Typeface.createFromAsset(getAssets(),fuentebold);

        String fuentethin = "fuentes/Comfortaa_Thin.ttf";
        this.confortaT = Typeface.createFromAsset(getAssets(),fuentethin);

        u = findViewById(R.id.tusuario);
        u.setTypeface(confortaR);
        m = findViewById(R.id.tmail);
        m.setTypeface(confortaR);
        c = findViewById(R.id.tcontrasena);
        c.setTypeface(confortaR);
        cc = findViewById(R.id.tconficon);
        cc.setTypeface(confortaR);

        log = findViewById(R.id.logear);
        log.setTypeface(confortaT);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registro.this,Login.class);
                startActivity(intent);
            }
        });

        usuario = findViewById(R.id.user);
        usuario.setTypeface(confortaR);

        mail = findViewById(R.id.email);
        mail.setTypeface(confortaR);

        contrasena = findViewById(R.id.contra);
        contrasena.setTypeface(confortaR);

        confirmarcion = findViewById(R.id.confirmcontra);
        confirmarcion.setTypeface(confortaR);

        registrar = findViewById(R.id.registro);
        registrar.setTypeface(confortaB);

       /* registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = usuario.getText().toString().trim();
                String correo = mail.getText().toString().trim();
                String password = contrasena.getText().toString().trim();
                String confirmacionpassword = confirmarcion.getText().toString().trim();

                Usuario usuario = new Usuario(correo, password);
                usuario.setEmail(correo);
                usuario.setContrasena(password);
                usuario.setConfirmacion(confirmacionpassword);

                Intent intent= new Intent(Registro.this,Main.class);
                startActivity(intent);
            }
        }); */

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarUsuario();
            }
        });

    }

    public void registrarUsuario(){
        //Validar datos del usuario
        if(usuario.getText().toString().isEmpty()){
            Toast.makeText(this, "El campo esta vacio", Toast.LENGTH_SHORT).show();
            return;
        }

        if(mail.getText().toString().isEmpty()){
            Toast.makeText(this, "El campo esta vacio", Toast.LENGTH_SHORT).show();
            return;
        }

        if(contrasena.getText().toString().isEmpty()){
            Toast.makeText(this, "El campo esta vacio", Toast.LENGTH_SHORT).show();
            return;
        }

        if(confirmarcion.getText().toString().isEmpty()){
            Toast.makeText(this, "No valido la contraseña", Toast.LENGTH_SHORT).show();
            return;
        }

        if(contrasena.getText().toString().length()<=5){
            Toast.makeText(this,"La contraseña debe tener mas de 5 digitos", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!contrasena.getText().toString().equals(confirmarcion.getText().toString())){
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.createUserWithEmailAndPassword(mail.getText().toString(), contrasena.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Registro.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                    //Esta autenticado
                    String uid = firebaseAuth.getCurrentUser().getUid();
                    Usuario usuario = new Usuario(mail.getText().toString(), contrasena.getText().toString());

                    DatabaseReference reference = firebaseDatabase.getReference("Usuarios").child(uid);

                    Intent i = new Intent(Registro.this,Main.class);
                    startActivity(i);
                }else{
                    Toast.makeText(Registro.this, "" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
