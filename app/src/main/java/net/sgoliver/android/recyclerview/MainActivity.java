package net.sgoliver.android.recyclerview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    private RecyclerView recView;
    private Button btnInsertar;
    private Button btnEliminar;
    private Button btnMover;

    private ArrayList<Alumnos> datos;
    private String i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datos = new ArrayList<Alumnos>();
        for(int i=0; i<50; i++)
            datos.add(new Alumnos("Nombre: " + i, "Apellido: " + i, "Clase: "+ i,"Curso: "+ i));

        recView = (RecyclerView) findViewById(R.id.RecView);
        recView.setHasFixedSize(true);

        final AdaptadorAlumnos adaptador = new AdaptadorAlumnos(datos);

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("DemoRecView", "Pulsado el elemento " + recView.getChildPosition(v));
            }
        });

        recView.setAdapter(adaptador);

        recView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        //recView.setLayoutManager(new GridLayoutManager(this,3));

        recView.addItemDecoration(
                new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

        recView.setItemAnimator(new DefaultItemAnimator());

        btnInsertar = (Button)findViewById(R.id.BtnInsertar);

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.add(1, new Alumnos("Nombre: " + i, "Nuevo Nombre: ", "Nuevo Apellido: ", "Curso: " + i));
                adaptador.notifyItemInserted(1);
            }
        });

        btnEliminar = (Button)findViewById(R.id.BtnEliminar);

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.remove(1);
                adaptador.notifyItemRemoved(1);
            }
        });

        btnMover = (Button)findViewById(R.id.BtnMover);

        btnMover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Alumnos aux = datos.get(1);
                datos.set(1,datos.get(2));
                datos.set(2,aux);

                adaptador.notifyItemMoved(1, 2);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
