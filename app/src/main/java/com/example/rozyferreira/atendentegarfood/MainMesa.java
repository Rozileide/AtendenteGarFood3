package com.example.rozyferreira.atendentegarfood;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;

import adapter.MesaAdapter;
import modelo.Mesa;

public class MainMesa extends AppCompatActivity {

    ListView listViewMesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mesa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList mesas = new ArrayList();
        mesas.add(new Mesa(1,"Mesa 1"));
        mesas.add(new Mesa(2, "Mesa 2"));
        mesas.add(new Mesa(3,"Mesa 3"));
        mesas.add(new Mesa(4,"Mesa 4"));
        mesas.add(new Mesa(5,"Mesa 5"));
        mesas.add(new Mesa(6,"Mesa 6"));
        mesas.add(new Mesa(7,"Mesa 7"));
        mesas.add(new Mesa(8,"Mesa 8"));
        mesas.add(new Mesa(9,"Mesa 9"));
        mesas.add(new Mesa(10,"Mesa 10"));
        mesas.add(new Mesa(11,"Mesa 11"));
        mesas.add(new Mesa(12,"Mesa 12"));

        listViewMesa = (ListView) findViewById(R.id.listViewMesa);
        listViewMesa.setAdapter(new MesaAdapter(this, mesas));
        listViewMesa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Mesa mesa = (Mesa) parent.getAdapter().getItem(position);
                //Intent intent = new Intent(MainActivity.this, SendMessage.class);
                //String message = entry.getMessage();
                //intent.putExtra(EXTRA_MESSAGE, message);
                //startActivity(intent);

                Intent intent = new Intent(MainMesa.this,MainAtendente.class);
                startActivity(intent);
//                Toast.makeText(getApplicationContext(),mesa.getNome(),Toast.LENGTH_LONG).show();
            }
        });

    }

}
