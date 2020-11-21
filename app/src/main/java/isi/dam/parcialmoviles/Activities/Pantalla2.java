package isi.dam.parcialmoviles.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
    ArrayList<String> lista = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (ListView) findViewById(R.id.listView);


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

    public void Registrar(View view){
        AdminSQLite admin = new AdminSQLite(this, "administracion", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

        String guardar =getIntent().getStringExtra("guardar");
        String nombre = null;
        String apellido = null;
        if(guardar.equals("nombre")){
            nombre =getIntent().getStringExtra("nombre");
        }else if(guardar.equals("apellido")){
            apellido =getIntent().getStringExtra("apellido");
        }

        ContentValues registro = new ContentValues();
        registro.put("nombre", nombre);
        registro.put("apellido", apellido);

        baseDeDatos.insert("persona", null, registro);
        baseDeDatos.close();

    }

    public void mostrarDatos(View view){
        AdminSQLite admin = new AdminSQLite(this, "administracion", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

        Cursor fila = baseDeDatos.rawQuery("select nombre, apellido from persona", null);

        if(fila.moveToFirst()){
            lista.add(fila.getString(0));
            lista.add(fila.getString(1));
            baseDeDatos.close();
        }else{
            baseDeDatos.close();
        }

    }



}