package es.joseljg.recyclerviewestudiante;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EstudianteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public ImageView img_foto =null;
    public TextView txt_dni = null;
    public TextView txt_nombre = null;
    public TextView txt_curso = null;
    public TextView txt_fechan = null;
    public TextView txt_horap = null;
    //-----------------------------------------
    public ListaEstudiantesAdapter le_adapter = null;

    public EstudianteViewHolder(@NonNull View itemView, ListaEstudiantesAdapter le_adapter) {
        super(itemView);
        img_foto = (ImageView) itemView.findViewById(R.id.img_foto);
        txt_dni = (TextView) itemView.findViewById(R.id.txt_dni);
        txt_nombre = (TextView) itemView.findViewById(R.id.txt_nombre);
        txt_curso = (TextView) itemView.findViewById(R.id.txt_curso);
        txt_fechan = (TextView) itemView.findViewById(R.id.txt_fechan);
        txt_horap = (TextView) itemView.findViewById(R.id.txt_horap);
        this.le_adapter = le_adapter;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
