package es.joseljg.recyclerviewestudiante;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

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
    //-----------------------------------------------------------------------------
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                ItemTouchHelper.DOWN | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                Collections.swap(estudiantes, from, to);
                adaptadorEstudiantes.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                if(direction == ItemTouchHelper.LEFT)
                {
                    mostrarToast("ha pulsado izquierda");
                    // Ciudad c = ciudades.get(viewHolder.getAdapterPosition());
                    // CiudadController.borrarCiudad(c);
                    estudiantes.remove(viewHolder.getAdapterPosition());
                    adaptadorEstudiantes.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
                if(direction == ItemTouchHelper.RIGHT)
                {
                    mostrarToast("ha pulsado derecha");
                    estudiantes.remove(viewHolder.getAdapterPosition());
                    adaptadorEstudiantes.notifyItemRemoved(viewHolder.getAdapterPosition());
                }
            }
        });
        helper.attachToRecyclerView(rv_estudiantes);
    }

    public void mostrarEstudiante(Estudiante e) {
        Toast.makeText(this,"dni->" + e.getDni() + "\n" + "nombre->"+ e.getNombre() + "\n"+ "fecha de nacimiento " + e.getFechan() + "\n" + "hora preferida de llamada " + e.getHorap() + "\n" + "curso->" + e.getCurso(), Toast.LENGTH_LONG).show();
    }

    private void mostrarToast(String texto) {
        Toast.makeText(this,texto, Toast.LENGTH_SHORT).show();
    }

}

