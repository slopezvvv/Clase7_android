package cl.tuserver.clase7_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ActividadDos extends AppCompatActivity {

    private ProgressBar progressBar;

    private LinearLayout contenido;

    private TextView tvRut, tvNombre, tvDireccion, tvTelefono;

    // Evento de creacion de la Actividad
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_dos);

        // Barra de progreso
        progressBar = findViewById(R.id.ProgressBar);

        // Layout contenido
        contenido = findViewById(R.id.Contenido);

        // TextView
        tvRut = findViewById(R.id.tvRut);
        tvNombre = findViewById(R.id.tvNombre);
        tvDireccion = findViewById(R.id.tvDireccion);
        tvTelefono = findViewById(R.id.tvTelefono);

        // Recuperamos el Intent
        Intent intent = getIntent();

        // Recuperamos los valores dentro del Intent
        Usuario usuario = (Usuario) intent.getSerializableExtra("USUARIO");

        // Modificamos el texto dentro de los TextViews
        // Deben asegurarse que el tipo de dato que se entrega sea un String SIEMPRE
        tvRut.setText(String.valueOf(usuario.getId()));
        tvNombre.setText(usuario.getNombre());
        tvDireccion.setText(usuario.getDireccion());
        tvTelefono.setText(String.valueOf(usuario.getTelefono()));
    }

    // Evento de inicio de la Actividad
    @Override
    protected void onStart(){
        super.onStart(); // Inicia el evento en el Padre

        // Inicio de Hilo anonimo
        new Thread(
            () -> {
                while(true){
                    try{
                        Thread.sleep(8000); // Tiempo de proceso simulado 8 segundos (ms)

                        // Este metodo sirve para integrar hilos a la vista de android.
                        // Sin este metodo, no podriamos modificar la vista en un hilo distinto.
                        runOnUiThread(
                            () -> { // Runnable lamda
                                contenido.setVisibility(View.VISIBLE); // Contenido Visible
                                progressBar.setVisibility(View.GONE); // Barra de progreso sacada del layout
                            }
                        );
                    }
                    catch (InterruptedException ie){
                        System.out.println(ie.getMessage());
                    }
                }
            }
        ).start(); // Iniciar hilo
    }
}