package isi.dam.parcialmoviles.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import isi.dam.parcialmoviles.R;

public class MainActivity extends AppCompatActivity {

    Button guardarNombre, guardarApellido;
    Toolbar toolbar;
    Switch switch_guardar;
    EditText nombre, apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent pasarPAntallla2 = new Intent(this, Pantalla2.class);

        guardarNombre = (Button) findViewById(R.id.guardar_nombre);
        guardarApellido = (Button) findViewById(R.id.guardar_apellido);

        guardarNombre.setVisibility(View.GONE);
        guardarApellido.setVisibility(View.GONE);

        nombre = (EditText) findViewById(R.id.editNombre);
        apellido = (EditText) findViewById(R.id.editApellido);

        guardarNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasarPAntallla2.putExtra("nombre", nombre.getText().toString());
                pasarPAntallla2.putExtra("guardar", "nombre");
                startActivity(pasarPAntallla2);
            }
        });

        guardarApellido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasarPAntallla2.putExtra("apellido", apellido.getText().toString());
                pasarPAntallla2.putExtra("guardar", "apellido");
                startActivity(pasarPAntallla2);
            }
        });

        switch_guardar = (Switch) findViewById(R.id.switch1);

        switch_guardar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(switch_guardar.isChecked()){
                    guardarNombre.setVisibility(View.VISIBLE);
                    guardarApellido.setVisibility(View.VISIBLE);
                }else{
                    guardarNombre.setVisibility(View.GONE);
                    guardarApellido.setVisibility(View.GONE);
                }
            }
        });


    }

}