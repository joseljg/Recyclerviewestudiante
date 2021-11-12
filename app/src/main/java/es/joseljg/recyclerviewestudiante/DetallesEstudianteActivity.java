package es.joseljg.recyclerviewestudiante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetallesEstudianteActivity extends AppCompatActivity {

    Estudiante e = null;
    TextView txt_detalles_dni = null;
    TextView txt_detalles_nombre = null;
    TextView txt_detalles_curso = null;
    TextView txt_detalles_fechan = null;
    TextView txt_detalles_horap = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_estudiante);
        //--------------------------------------------------------
        txt_detalles_dni = (TextView) findViewById(R.id.txt_detalles_dni);
        txt_detalles_nombre = (TextView) findViewById(R.id.txt_detalles_nombre);
        txt_detalles_curso = (TextView) findViewById(R.id.txt_detalles_curso);
        txt_detalles_fechan = (TextView) findViewById(R.id.txt_detalles_fechan);
        txt_detalles_horap = (TextView) findViewById(R.id.txt_detalles_horap);
        Intent intent = getIntent();
        if(intent != null)
        {
           e = (Estudiante)intent.getSerializableExtra(EstudianteViewHolder.EXTRA_OBJETO_ESTUDIANTE);
           String dni = e.getDni();
           String nombre = e.getNombre();
           String curso = e.getCurso();
           String fechan = e.getFechan();
           String horap = e.getHorap();
           txt_detalles_dni.setText("dni: " + dni);
           txt_detalles_nombre.setText("nombre: " + nombre);
           txt_detalles_curso.setText("curso: " + curso);
           txt_detalles_fechan.setText("fecha de nacimiento: " + fechan);
           txt_detalles_horap.setText("hora preferida llamada" + horap);

        }
    }

    public void cerrardetalles(View view) {
        finish();
    }
}