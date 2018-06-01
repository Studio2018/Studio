package lu.dmi.icesi.studio;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QR extends AppCompatActivity {

    Button generate;
    EditText code;
    ImageView qr;
    String textQR;
    ImageButton botonCat, carpetas, calendario, playlist, admcuenta;


    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);

        generate = (Button) findViewById(R.id.generate);
        code = (EditText) findViewById(R.id.code);
        qr = (ImageView) findViewById(R.id.qr);

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //generar codifo qr a partir del codigo del estudiante

                textQR = code.getText().toString();
                try{
                    BitMatrix bitMatrix = multiFormatWriter.encode(textQR, BarcodeFormat.QR_CODE, 400, 400)  ;
                    BarcodeEncoder encoder = new BarcodeEncoder();
                    Bitmap bitmap = encoder.createBitmap(bitMatrix);
                    qr.setImageBitmap(bitmap);

                } catch (WriterException e) {
                    e.printStackTrace();
                }


            }
        });

        carpetas = findViewById(R.id.files);
        carpetas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QR.this,Carpeta.class);
                startActivity(intent);
            }
        });
        calendario= findViewById(R.id.calendar);
        calendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QR.this,Calendario.class);
                startActivity(intent);
            }
        });
        playlist = findViewById(R.id.music);
        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QR.this,PlayLists.class);
                startActivity(intent);
            }
        });
        admcuenta = findViewById(R.id.persona);
        admcuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QR.this,Admcuenta.class);
                startActivity(intent);            }
        });

    }

}
