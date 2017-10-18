package net.sgoliver.android.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorAlumnos
        extends RecyclerView.Adapter<AdaptadorAlumnos.TitularesViewHolder>
        implements View.OnClickListener {

    private View.OnClickListener listener;
    private ArrayList<Alumnos> datos;

    public static class TitularesViewHolder
            extends RecyclerView.ViewHolder {

        private TextView txtNombre;
        private TextView txtClase;
        private TextView txtApellido;
        private TextView txtCurso;

        public TitularesViewHolder(View itemView) {
            super(itemView);

            txtNombre = (TextView)itemView.findViewById(R.id.LblNombre);
            txtClase = (TextView)itemView.findViewById(R.id.LblClase);
            txtApellido = (TextView)itemView.findViewById(R.id.lblApellido);
            txtCurso = (TextView)itemView.findViewById(R.id.lblCurso);

        }

        public void bindTitular(Alumnos t) {
            txtNombre.setText(t.getNombre());
            txtApellido.setText(t.getApellido());
            txtClase.setText(t.getClase());
            txtCurso.setText(t.getCurso());

        }
    }

    public AdaptadorAlumnos(ArrayList<Alumnos> datos) {
        this.datos = datos;
    }

    @Override
    public TitularesViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.listitem_titular, viewGroup, false);

        itemView.setOnClickListener(this);
        //android:background="?android:attr/selectableItemBackground"

        TitularesViewHolder tvh = new TitularesViewHolder(itemView);

        return tvh;
    }

    @Override
    public void onBindViewHolder(TitularesViewHolder viewHolder, int pos) {
        Alumnos item = datos.get(pos);

        viewHolder.bindTitular(item);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }
}
