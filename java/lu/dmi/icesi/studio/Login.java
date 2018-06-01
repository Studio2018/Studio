package lu.dmi.icesi.studio;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private EditText usuario, contrasena;
    private Button login;
    private TextView registro, textocontrasena, textousuario;

    private Typeface confortaB, confortaR, confortaT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        String fuenteregular = "fuentes/Comfortaa_Regular.ttf";
        this.confortaR = Typeface.createFromAsset(getAssets(),fuenteregular);

        String fuentebold = "fuentes/Comfortaa_Bold.ttf";
        this.confortaB = Typeface.createFromAsset(getAssets(),fuentebold);

        String fuentethin = "fuentes/Comfortaa_Thin.ttf";
        this.confortaT = Typeface.createFromAsset(getAssets(),fuentethin);

        usuario = findViewById(R.id.usuario);
        usuario.setTypeface(confortaR);

        contrasena = findViewById(R.id.contrasena);
        contrasena.setTypeface(confortaR);

        textocontrasena = findViewById(R.id.textocontrasena);
        textocontrasena.setTypeface(confortaR);
        textousuario = findViewById(R.id.textousuario);
        textousuario.setTypeface(confortaR);

        registro = findViewById(R.id.registrar);
        registro.setTypeface(confortaT);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Registro.class);
                startActivity(intent);
            }
        });

        login = findViewById(R.id.login);
        login.setTypeface(confortaB);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = usuario.getText().toString().trim();
                String password = contrasena.getText().toString().trim();

                Intent intent = new Intent(Login.this, Main.class);
                startActivity(intent);

            }
        });

    }
}
