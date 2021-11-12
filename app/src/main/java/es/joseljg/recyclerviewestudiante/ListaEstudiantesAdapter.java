package es.joseljg.recyclerviewestudiante;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaEstudiantesAdapter extends RecyclerView.Adapter<EstudianteViewHolder> {
   // atributos
   private Context c = null;
   private ArrayList<Estudiante> estudiantes;
   private LayoutInflater le_inflater;

    public Context getC() {
        return c;
    }

    public void setC(Context c) {
        this.c = c;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public ListaEstudiantesAdapter(Context context, ArrayList<Estudiante> estudiantes) {
        this.c = context;
        this.estudiantes = estudiantes;
        le_inflater = LayoutInflater.from(c);
    }

    @NonNull
    @Override
    public EstudianteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = le_inflater.inflate(R.layout.item_lista_estudiantes,parent,false);
        EstudianteViewHolder evh = new EstudianteViewHolder(mItemView,this);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull EstudianteViewHolder holder, int position) {
        Estudiante estudianteSeleccionado = estudiantes.get(position);
        holder.txt_dni.setText("dni: " + estudianteSeleccionado.getDni());
        holder.txt_nombre.setText("nombre: " + estudianteSeleccionado.getNombre());
        holder.txt_curso.setText("curso: " + estudianteSeleccionado.getCurso());
        holder.txt_fechan.setText("fecha de nacimiento: " + estudianteSeleccionado.getFechan());
        holder.txt_horap.setText(("hora preferida " + estudianteSeleccionado.getHorap()));
    }

    @Override
    public int getItemCount() {
        return estudiantes.size();
    }
}
