package lu.dmi.icesi.studio;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlayListExpandida extends AppCompatActivity {

    ImageView imagenplaylist;
    TextView nombreplaylist;
    TextView nombrealbum;
    Button reproducir;
    ListView mislistas;
    ArrayAdapter<String> adapter;
    ArrayList<String> songs;
    ArrayList<MediaPlayer> songscomplete;
    ImageButton atras,play,next;

    ImageButton botonCat, carpetas, calendario, playlist, admcuenta;
    public MediaPlayer mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10;

    ImageButton files;
    ImageButton music;
    ImageButton calendar;
    ImageButton persona;

    int maxVolume = 50;

    int pasar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list_expandida);

        imagenplaylist = (ImageView) findViewById(R.id.imagenplaylist);
        nombreplaylist = (TextView) findViewById(R.id.nombreplaylist);
        //nombrealbum = (TextView) findViewById(R.id.nombrealbum);
        reproducir = (Button) findViewById(R.id.reproducir);
        mislistas = (ListView) findViewById(R.id.mislistas);


        songscomplete = new ArrayList<MediaPlayer>();

        mp1 = new MediaPlayer().create(PlayListExpandida.this, R.raw.irishcelebration);
        mp2 = new MediaPlayer().create(PlayListExpandida.this, R.raw.quedate);
        mp3 = new MediaPlayer().create(PlayListExpandida.this, R.raw.tufoto);
        mp4 = new MediaPlayer().create(PlayListExpandida.this, R.raw.invencible);
        mp5 = new MediaPlayer().create(PlayListExpandida.this, R.raw.congratulations);
        mp6 = new MediaPlayer().create(PlayListExpandida.this, R.raw.thisisamerica);
        mp7 = new MediaPlayer().create(PlayListExpandida.this, R.raw.sinsentimiento);
        mp8 = new MediaPlayer().create(PlayListExpandida.this, R.raw.amorfoda);
        mp9 = new MediaPlayer().create(PlayListExpandida.this, R.raw.saved);
        mp10 = new MediaPlayer().create(PlayListExpandida.this, R.raw.porperro);


        atras = (ImageButton) findViewById(R.id.atras);
        play = (ImageButton) findViewById(R.id.play);
        next = (ImageButton) findViewById(R.id.next);


        songs = new ArrayList<String>();
        songs.add("Irish Celebration \nMacklemore");
        songs.add("Quedate \nManuel Medrano");
        songs.add("Tu Foto \nOzuna");
        songs.add("Invencible \nChoquibdown");
        songs.add("Congratulations \nPost Malone");
        songs.add("This is America \nChildish Gambino");
        songs.add("Sin sentimiento \nGrupo Niche");
        songs.add("Amorfoda \nBad Bunny");
        songs.add("Saved \nKhalid");
        songs.add("Por perro \nSebastian Yatra");

        carpetas = findViewById(R.id.files);
        carpetas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayListExpandida.this, Carpeta.class);
                startActivity(intent);
            }
        });
        calendario = findViewById(R.id.calendar);
        calendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayListExpandida.this, Calendario.class);
                startActivity(intent);
            }
        });
        playlist = findViewById(R.id.music);
        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayListExpandida.this, PlayLists.class);
                startActivity(intent);
            }
        });
        admcuenta = findViewById(R.id.persona);
        admcuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayListExpandida.this, Admcuenta.class);
                startActivity(intent);
            }
        });


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songs);
        mislistas = (ListView) findViewById(R.id.mislistas);
        mislistas.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        //Selecciono una cancion en particular para que se reproduzca
        mislistas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(position);

                //pasar = (int) mislistas.getItemAtPosition(position);

                //Doy click en uno de los items, y segun la posicion se reproduce la cancion y se detiene la cancion que este sonando
                switch (position) {
                    case 0:

                        songscomplete.add(mp1 = new MediaPlayer().create(PlayListExpandida.this, R.raw.irishcelebration));
                        mp1.start();
                        mp2.stop(); mp3.stop(); mp4.stop(); mp5.stop(); mp6.stop(); mp7.stop();
                        mp8.stop(); mp9.stop(); mp10.stop();
                        //float log1 = (float) (Math.log(maxVolume-20)/Math.log(maxVolume));
                        //mp1.setVolume(log1,log1);
                        break;


                    case 1:

                        songscomplete.add(mp2 = new MediaPlayer().create(PlayListExpandida.this, R.raw.quedate));
                        mp2.start();
                        mp1.stop(); mp3.stop(); mp4.stop(); mp5.stop(); mp6.stop();
                        mp7.stop(); mp8.stop(); mp9.stop(); mp10.stop();


                        break;

                    case 2:

                        songscomplete.add(mp3 = new MediaPlayer().create(PlayListExpandida.this, R.raw.tufoto));
                        mp3.start();
                        mp1.stop(); mp2.stop(); mp4.stop(); mp5.stop(); mp6.stop();
                        mp7.stop(); mp8.stop(); mp9.stop(); mp10.stop();


                        break;

                    case 3:

                        songscomplete.add(mp4 = new MediaPlayer().create(PlayListExpandida.this, R.raw.invencible));
                        mp4.start();
                        mp1.stop(); mp3.stop(); mp2.stop(); mp5.stop(); mp6.stop();
                        mp7.stop(); mp8.stop(); mp9.stop(); mp10.stop();

                        break;

                    case 4:


                        songscomplete.add(mp5 = new MediaPlayer().create(PlayListExpandida.this, R.raw.congratulations));
                        mp5.start();
                        mp1.stop(); mp3.stop(); mp4.stop(); mp2.stop(); mp6.stop();
                        mp7.stop(); mp8.stop(); mp9.stop(); mp10.stop();

                        break;

                    case 5:

                        songscomplete.add(mp6 = new MediaPlayer().create(PlayListExpandida.this, R.raw.thisisamerica));
                        mp6.start();
                        mp1.stop(); mp3.stop(); mp4.stop(); mp5.stop(); mp2.stop();
                        mp7.stop(); mp8.stop(); mp9.stop(); mp10.stop();

                        break;

                    case 6:

                        songscomplete.add(mp7 = new MediaPlayer().create(PlayListExpandida.this, R.raw.sinsentimiento));
                        mp7.start();
                        mp1.stop(); mp3.stop(); mp4.stop(); mp5.stop(); mp6.stop();
                        mp2.stop(); mp8.stop(); mp9.stop(); mp10.stop();

                        break;

                    case 7:

                        songscomplete.add(mp8 = new MediaPlayer().create(PlayListExpandida.this, R.raw.amorfoda));
                        mp8.start();
                        mp1.stop(); mp3.stop(); mp4.stop(); mp5.stop(); mp6.stop();
                        mp7.stop(); mp2.stop(); mp9.stop(); mp10.stop();


                        break;

                    case 8:

                        songscomplete.add(mp9 = new MediaPlayer().create(PlayListExpandida.this, R.raw.saved));
                        mp9.start();
                        mp1.stop(); mp3.stop(); mp4.stop(); mp5.stop(); mp6.stop();
                        mp7.stop(); mp8.stop(); mp2.stop(); mp10.stop();

                        break;

                    case 9:

                        songscomplete.add(mp10 = new MediaPlayer().create(PlayListExpandida.this, R.raw.porperro));
                        mp10.start();
                        mp1.stop(); mp3.stop(); mp4.stop(); mp5.stop(); mp6.stop();
                        mp7.stop(); mp8.stop(); mp9.stop(); mp2.stop();

                        break;


                }
            }
        });


        // Metodo para reproducir todas las canciones de la playlist

        reproducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                songscomplete = new ArrayList<MediaPlayer>();


                songscomplete.add(mp1 = new MediaPlayer().create(PlayListExpandida.this, R.raw.irishcelebration));
                mp1.start();

                //setOnCompletionListener valida que si la cancion ya se ha acabado se reproduzca la siguiente
                mp1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {


                        songscomplete.add(mp2 = new MediaPlayer().create(PlayListExpandida.this, R.raw.quedate));
                        mp2.start();

                        mp2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {

                                songscomplete.add(mp3 = new MediaPlayer().create(PlayListExpandida.this, R.raw.tufoto));
                                mp3.start();

                                mp3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {


                                        songscomplete.add(mp4 = new MediaPlayer().create(PlayListExpandida.this, R.raw.invencible));
                                        mp4.start();

                                        mp4.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                            @Override
                                            public void onCompletion(MediaPlayer mp) {


                                                songscomplete.add(mp5 = new MediaPlayer().create(PlayListExpandida.this, R.raw.congratulations));
                                                mp5.start();

                                                mp5.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                                    @Override
                                                    public void onCompletion(MediaPlayer mp) {


                                                        songscomplete.add(mp6 = new MediaPlayer().create(PlayListExpandida.this, R.raw.thisisamerica));
                                                        mp6.start();

                                                        mp6.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                                            @Override
                                                            public void onCompletion(MediaPlayer mp) {


                                                                songscomplete.add(mp7 = new MediaPlayer().create(PlayListExpandida.this, R.raw.sinsentimiento));
                                                                mp7.start();

                                                                mp7.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                                                    @Override
                                                                    public void onCompletion(MediaPlayer mp) {


                                                                        songscomplete.add(mp8 = new MediaPlayer().create(PlayListExpandida.this, R.raw.amorfoda));
                                                                        mp8.start();

                                                                        mp8.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                                                            @Override
                                                                            public void onCompletion(MediaPlayer mp) {


                                                                                songscomplete.add(mp9 = new MediaPlayer().create(PlayListExpandida.this, R.raw.saved));
                                                                                mp9.start();

                                                                                mp9.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                                                                    @Override
                                                                                    public void onCompletion(MediaPlayer mp) {

                                                                                        songscomplete.add(mp10 = new MediaPlayer().create(PlayListExpandida.this, R.raw.porperro));
                                                                                        mp10.start();
                                                                                    }
                                                                                });
                                                                            }
                                                                        });
                                                                    }
                                                                });
                                                            }
                                                        });
                                                    }
                                                });
                                            }
                                        });
                                    }
                                });
                            }
                        });

                    }
                });
            }
        });

        //pausar o reproducir una canción
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //reproducir o detener la primera cancion
                if (mp1.isPlaying()) {
                    mp1.pause();
                    play.setBackgroundResource(R.drawable.play);
                    Toast.makeText(PlayListExpandida.this, "Pausa", Toast.LENGTH_SHORT).show();
                } else {
                    mp1.start();
                    play.setBackgroundResource(R.drawable.pausa);
                    Toast.makeText(PlayListExpandida.this, "Play", Toast.LENGTH_SHORT).show();
                }


                //reproducir o detener la segunda cancion
                if(mp2.isPlaying()){
                    mp2.pause();
                    play.setBackgroundResource(R.drawable.play);
                    Toast.makeText(PlayListExpandida.this, "Pausa", Toast.LENGTH_SHORT).show();
                }else {
                    mp2.start();
                    play.setBackgroundResource(R.drawable.pausa);
                    Toast.makeText(PlayListExpandida.this, "Play", Toast.LENGTH_SHORT).show();
                }


                //reproducir o detener la tercera cancion
                if(mp3.isPlaying()){
                    mp3.pause();
                    play.setBackgroundResource(R.drawable.play);
                    Toast.makeText(PlayListExpandida.this, "Pausa", Toast.LENGTH_SHORT).show();
                }else {
                    mp3.start();
                    play.setBackgroundResource(R.drawable.pausa);
                    Toast.makeText(PlayListExpandida.this, "Play", Toast.LENGTH_SHORT).show();
                }

                //reproducir o detener la cuarta cancion
                if(mp4.isPlaying()){
                    mp4.pause();
                    play.setBackgroundResource(R.drawable.play);
                    Toast.makeText(PlayListExpandida.this, "Pausa", Toast.LENGTH_SHORT).show();
                }else {
                    mp4.start();
                    play.setBackgroundResource(R.drawable.pausa);
                    Toast.makeText(PlayListExpandida.this, "Play", Toast.LENGTH_SHORT).show();
                }

                //reproducir o detener la quinta cancion
                if(mp5.isPlaying()){
                    mp5.pause();
                    play.setBackgroundResource(R.drawable.play);
                    Toast.makeText(PlayListExpandida.this, "Pausa", Toast.LENGTH_SHORT).show();
                }else {
                    mp5.start();
                    play.setBackgroundResource(R.drawable.pausa);
                    Toast.makeText(PlayListExpandida.this, "Play", Toast.LENGTH_SHORT).show();
                }

                //reproducir o detener la sexta cancion
                if(mp6.isPlaying()){
                    mp6.pause();
                    play.setBackgroundResource(R.drawable.play);
                    Toast.makeText(PlayListExpandida.this, "Pausa", Toast.LENGTH_SHORT).show();
                }else {
                    mp6.start();
                    play.setBackgroundResource(R.drawable.pausa);
                    Toast.makeText(PlayListExpandida.this, "Play", Toast.LENGTH_SHORT).show();
                }

                //reproducir o detener la septima cancion
                if(mp7.isPlaying()){
                    mp7.pause();
                    play.setBackgroundResource(R.drawable.play);
                    Toast.makeText(PlayListExpandida.this, "Pausa", Toast.LENGTH_SHORT).show();
                }else {
                    mp7.start();
                    play.setBackgroundResource(R.drawable.pausa);
                    Toast.makeText(PlayListExpandida.this, "Play", Toast.LENGTH_SHORT).show();
                }

                //reproducir o detener la octava cancion
                if(mp8.isPlaying()){
                    mp8.pause();
                    play.setBackgroundResource(R.drawable.play);
                    Toast.makeText(PlayListExpandida.this, "Pausa", Toast.LENGTH_SHORT).show();
                }else {
                    mp8.start();
                    play.setBackgroundResource(R.drawable.pausa);
                    Toast.makeText(PlayListExpandida.this, "Play", Toast.LENGTH_SHORT).show();
                }

                //reproducir o detener la novena cancion
                if(mp9.isPlaying()){
                    mp9.pause();
                    play.setBackgroundResource(R.drawable.play);
                    Toast.makeText(PlayListExpandida.this, "Pausa", Toast.LENGTH_SHORT).show();
                }else {
                    mp9.start();
                    play.setBackgroundResource(R.drawable.pausa);
                    Toast.makeText(PlayListExpandida.this, "Play", Toast.LENGTH_SHORT).show();
                }

                //reproducir o detener la decima cancion
                if(mp10.isPlaying()){
                    mp10.pause();
                    play.setBackgroundResource(R.drawable.play);
                    Toast.makeText(PlayListExpandida.this, "Pausa", Toast.LENGTH_SHORT).show();
                }else {
                    mp10.start();
                    play.setBackgroundResource(R.drawable.pausa);
                    Toast.makeText(PlayListExpandida.this, "Play", Toast.LENGTH_SHORT).show();
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasar();
            }
            });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volver();
            }
        });
        }

    public void pasar(){
        pasar +=1;
    }
        //pasar a la siguiente canción

        //devolverme a la anterior cancion

    public void volver(){
        pasar -=1;
    }



    public ImageView getImagenplaylist() {
        return imagenplaylist;
    }

    public void setImagenplaylist(ImageView imagenplaylist) {
        this.imagenplaylist = imagenplaylist;
    }

    public TextView getNombreplaylist() {
        return nombreplaylist;
    }

    public void setNombreplaylist(TextView nombreplaylist) {
        this.nombreplaylist = nombreplaylist;
    }

    public ArrayList<String> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<String> songs) {
        this.songs = songs;
    }


}
