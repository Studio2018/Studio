package lu.dmi.icesi.studio;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Reproductor extends AppCompatActivity {

    ImageButton play;
    ImageButton atras, adelante;
    TextView nombrecancion,nombredeartista,nombreplaylist,estadoplaylist;
    ImageView imagencancion;
    //ArrayList<MediaPlayer> music;
    //MediaPlayer mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10;

    ImageButton botonCat, carpetas, calendario, playlist, admcuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);

        play = (ImageButton) findViewById(R.id.play);
        atras = (ImageButton) findViewById(R.id.atras);
        adelante = (ImageButton) findViewById(R.id.adelante);
        nombrecancion = (TextView) findViewById(R.id.nombrecancion);
        nombredeartista = (TextView) findViewById(R.id.nombredeartista);
        nombreplaylist = (TextView) findViewById(R.id.nombreplaylist);
        estadoplaylist = (TextView) findViewById(R.id.estadoplaylist);
        imagencancion = (ImageView) findViewById(R.id.imagencancion);

        //music = new ArrayList<MediaPlayer>();
        //music.add(new MediaPlayer().create(Reproductor.this,R.raw.irishcelebration));


        /*play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(.isPlaying()){
                    play.setBackgroundResource(R.drawable.pausa);
                }
            }
        });*/


        //mp1 = MediaPlayer.create(   Reproductor.this,R.raw.irishcelebration);
        //mp1.start();

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if(mp1.isPlaying() || mp2.isPlaying() || mp3.isPlaying() || mp4.isPlaying()
                        || mp5.isPlaying() || mp6.isPlaying() || mp7.isPlaying() || mp8.isPlaying()
                        || mp9.isPlaying() || mp10.isPlaying()){

                    mp1.pause();
                    //play.setBackgroundResource(R.drawable.p);
                } else{
                    mp1.start(); mp2.start(); mp3.start(); mp4.start(); mp5.start();
                    mp6.start(); mp7.start(); mp8.start(); mp9.start(); mp10.start();
                    play.setBackgroundResource(R.drawable.play);


                }*/


            }
        });


        /*mp1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                mp2 = new MediaPlayer().create(Reproductor.this,R.raw.quedate);
                mp2.start();

    }
});*/

        carpetas = findViewById(R.id.files);
        carpetas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Reproductor.this,Carpeta.class);
                startActivity(intent);
            }
        });
        calendario= findViewById(R.id.calendar);
        calendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Reproductor.this,Calendario.class);
                startActivity(intent);
            }
        });
        playlist = findViewById(R.id.music);
        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Reproductor.this,PlayLists.class);
                startActivity(intent);
            }
        });
        admcuenta = findViewById(R.id.persona);
        admcuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Reproductor.this,Admcuenta.class);
                startActivity(intent);            }
        });
    }
}
