package lu.dmi.icesi.studio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import leidercalvo.envio.Modelo;

public class EstadoUsuario extends AppCompatActivity {

    Button molestar, noMo;

    ComtoMesa comtoMesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estado_usuario);

        molestar= findViewById(R.id.molestar);
        noMo= findViewById(R.id.nomolestar);
        comtoMesa.getInstance("",5000);

        molestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Modelo m = new Modelo("1","","");
                comtoMesa.enviar(m);
            }
        });

        noMo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Modelo m = new Modelo("2","","");
                comtoMesa.enviar(m);
            }
        });
    }
}
