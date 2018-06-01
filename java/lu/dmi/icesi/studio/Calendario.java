package lu.dmi.icesi.studio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.timessquare.CalendarPickerView;

import java.util.Calendar;
import java.util.Date;

public class Calendario extends AppCompatActivity {

    TextView currentdate;
    ImageButton addevento;
    ListView eventos;
    EditText nombreevento, inicio, fina;
    String fechaseleccionada;
    Adaptadorfecha adaptador;

    ImageButton botonCat, carpetas, calendario, playlist, admcuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        adaptador = new Adaptadorfecha(this);
        eventos = findViewById(R.id.eventos);
        eventos.setAdapter(adaptador);

        currentdate = findViewById(R.id.currentdate);
        addevento = findViewById(R.id.addevento);

        nombreevento = findViewById(R.id.nombreevento);
        inicio = findViewById(R.id.inicio);
        fina = findViewById(R.id.fin);

        Date today = new Date();
        Calendar nexYear = Calendar.getInstance();
        nexYear.add(Calendar.YEAR, 1);

        CalendarPickerView datePicker = findViewById(R.id.calendario);
        datePicker.init(today,nexYear.getTime()).withSelectedDate(today).inMode(CalendarPickerView.SelectionMode.RANGE).withSelectedDate(today);

        datePicker.getSelectedDates();

        datePicker.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);

                final String selectedDate = "" + calendar.get(calendar.DAY_OF_MONTH) + "/" + (calendar.get(Calendar.MONTH)+1) + "/" + calendar.get(calendar.YEAR);
                //Toast.makeText(MainActivity.this,selectedDate,Toast.LENGTH_LONG).show();
                currentdate.setText(selectedDate);
                fechaseleccionada = selectedDate;

            }

            @Override
            public void onDateUnselected(Date date) {

            }
        });

        addevento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Evento nuevo= new Evento(fechaseleccionada,nombreevento.getText().toString().trim(),inicio.getText().toString().trim(),fina.getText().toString().trim());
                adaptador.addevento(nuevo);
                nombreevento.getText().clear();
                inicio.getText().clear();
                fina.getText().clear();

                //Intent intent = new Intent(MainActivity.this, CrearEvento.class);
                //intent.putExtra("fecha", fechaseleccionada);
                //startActivity(intent);
                //crearevento();
            }
        });

        carpetas = findViewById(R.id.files);
        carpetas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calendario.this,Carpeta.class);
                startActivity(intent);
            }
        });
        calendario= findViewById(R.id.calendar);
        calendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calendario.this,Calendario.class);
                startActivity(intent);
            }
        });
        playlist = findViewById(R.id.music);
        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calendario.this,PlayLists.class);
                startActivity(intent);
            }
        });
        admcuenta = findViewById(R.id.persona);
        admcuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calendario.this,Admcuenta.class);
                startActivity(intent);
            }
        });
    }
}
