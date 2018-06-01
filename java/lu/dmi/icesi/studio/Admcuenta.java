package lu.dmi.icesi.studio;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.zxing.MultiFormatWriter;

import java.util.ArrayList;

public class Admcuenta extends AppCompatActivity {

    Button generate;
    ImageButton vercontactos;

    ImageButton botonCat, carpetas, calendario, playlist, admcuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admcuenta);

        generate = (Button) findViewById(R.id.generate);
        vercontactos = (ImageButton) findViewById(R.id.vercontactos);

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Admcuenta.this, QR.class);
                startActivity(intent);
            }
        });

        vercontactos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Admcuenta.this, MisContactos.class);
                startActivity(intent2);
            }
        });

        carpetas = findViewById(R.id.files);
        carpetas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admcuenta.this,Carpeta.class);
                startActivity(intent);
            }
        });
        calendario= findViewById(R.id.calendar);
        calendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admcuenta.this,Calendario.class);
                startActivity(intent);
            }
        });
        playlist = findViewById(R.id.music);
        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admcuenta.this,PlayLists.class);
                startActivity(intent);
            }
        });
        admcuenta = findViewById(R.id.persona);
        admcuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admcuenta.this,Admcuenta.class);
                startActivity(intent);
            }
        });


    }



}
