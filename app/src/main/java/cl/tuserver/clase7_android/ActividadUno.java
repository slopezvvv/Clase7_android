package cl.tuserver.clase7_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ActividadUno extends AppCompatActivity {

    private EditText eRut, eNombre, eDireccion, eTelefono;
    private Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_uno);

        // EditText
        eRut = findViewById(R.id.eRut);
        eNombre = findViewById(R.id.eNombre);
        eDireccion = findViewById(R.id.eDireccion);
        eTelefono = findViewById(R.id.eTelefono);
        // Button
        btnRegistrar = findViewById(R.id.btnRegistrar);

        // Evento del boton
        btnRegistrar.setOnClickListener(v -> eventoRegistrar());
    }

    private void eventoRegistrar(){
        // Recureramos RUT
        int rut = Integer.parseInt(eRut.getText().toString());

        // Instancia de Usuario
        Usuario usuario = new Usuario(rut);

        // Mutadores Usuario
        usuario.setNombre(eNombre.getText().toString());
        usuario.setDireccion(eDireccion.getText().toString());
        usuario.setTelefono(Integer.parseInt(eTelefono.getText().toString()));

        // Recuerden que la Actividad a la que queremos llegar debe ir .class ya que el intent necesita la definicion o clase.
        Intent intent = new Intent(this, ActividadDos.class);

        // putExtra es un metodo que relaciona   Clave / Valor, asi con la clave correcta accedemos al valor correcto.
        intent.putExtra("USUARIO", usuario);

        // Iniciamos la Actividad
        startActivity(intent);
    }
}
