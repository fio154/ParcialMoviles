package isi.dam.parcialmoviles.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import isi.dam.parcialmoviles.R;

public class Pantalla2 extends AppCompatActivity {

    Toolbar toolbar;
    ListView listView;
    ArrayAdapter<String> myAdapter;
    ArrayList<String> lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (ListView) findViewById(R.id.listView);

        lista = new ArrayList<String>();
        String guardar =getIntent().getStringExtra("guardar");
        if(guardar.equals("nombre")){
            String nombre =getIntent().getStringExtra("nombre");
            lista.add(nombre);
        }else if(guardar.equals("apellido")){
            String apellido =getIntent().getStringExtra("apellido");
            lista.add(apellido);
        }
        myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        listView.setAdapter(myAdapter);

    }
}