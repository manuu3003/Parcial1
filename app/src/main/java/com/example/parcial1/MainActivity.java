package com.example.parcial1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener, View.OnClickListener {
    private List<Cancion> listado;
    private Spinner spnPersonaje;
    private ListView lstCancion;
    private EditText txtnombre;
    private RadioGroup rgTipo;
    private Button btnGrabar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Cancion temp;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnombre =findViewById(R.id.et_nombre);
        spnPersonaje = findViewById(R.id.spn_version);

        rgTipo = findViewById(R.id.rg_tipo);
        btnGrabar = findViewById(R.id.btn_grabar);
        lstCancion = findViewById(R.id.lst_canciones);
        listado = new ArrayList<Cancion>();
        String[] letra = {"En vivo","Especial","Normal"};
        spnPersonaje.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, letra));




        btnGrabar.setOnClickListener(this);
        lstCancion.setAdapter(new CancionAdapter(this, listado));
        lstCancion.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, listado.get(position).getNombre() + " de la lista", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, listado.get(position).getNombre(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Cancion cancion = ((Cancion)spnPersonaje.getSelectedItem());
        Toast.makeText(this,cancion.getNombre() + " no se cambio seleccion", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        Cancion temp;

                temp = new Cancion();
                temp.setNombre(txtnombre.getText().toString());
                temp.setVersion(spnPersonaje.getSelectedItem().toString());
                int tipo = 0;
                /*  Metodo con IF... se utiliza en el siguiente bloque WHILE*/
                if ((( RadioButton )rgTipo.getChildAt(0)).isChecked()) {
                    temp.setTipo(1);
                } else if (((RadioButton)rgTipo.getChildAt(1)).isChecked()) {
                    temp.setTipo(2);
                } else {
                    temp.setTipo(3);
                }

                txtnombre.setText("");

                ((RadioButton)rgTipo.getChildAt(0)).setChecked(true);

                Toast.makeText(this,"Click sobre guardar", Toast.LENGTH_SHORT).show();
                listado.add(temp);

        lstCancion.setAdapter(new CancionAdapter(this, listado));
        lstCancion.setOnItemClickListener(this);

    }
}
