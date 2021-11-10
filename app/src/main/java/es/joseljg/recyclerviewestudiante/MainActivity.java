package es.joseljg.recyclerviewestudiante;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Estudiante> estudiantes = null;
    private RecyclerView rv_estudiantes = null;
    private ListaEstudiantesAdapter adaptadorEstudiantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //--------------------------------------------------------------------------
        rv_estudiantes = (RecyclerView) findViewById(R.id.rv_estudiantes);
    //--------------------------------------------------------------------------
    estudiantes = new ArrayList<Estudiante>();
    estudiantes.add(new Estudiante("dni1","nombre1","curso1","1/1/2","1:23"));
    estudiantes.add(new Estudiante("dni2","nombre2","curso1","1/1/2","1:21"));
    estudiantes.add(new Estudiante("dni3","nombre3","curso1","1/1/3","1:22"));
    estudiantes.add(new Estudiante("dni4","nombre4","curso1","1/1/4","1:24"));
    estudiantes.add(new Estudiante("dni5","nombre5","curso2","1/1/5","1:25"));
    estudiantes.add(new Estudiante("dni6","nombre6","curso2","1/1/6","1:26"));
    estudiantes.add(new Estudiante("dni7","nombre7","curso2","1/1/7","1:27"));
    estudiantes.add(new Estudiante("dni8","nombre8","curso2","1/1/8","1:28"));
    //------------------------------------------------------------------------
    adaptadorEstudiantes = new ListaEstudiantesAdapter(this,estudiantes);
    rv_estudiantes.setAdapter(adaptadorEstudiantes);
    rv_estudiantes.setLayoutManager(new LinearLayoutManager(this));

    }
}