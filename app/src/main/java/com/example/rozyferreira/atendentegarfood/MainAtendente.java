package com.example.rozyferreira.atendentegarfood;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.Date;

import adapter.ItemProdutoAdapter;
import adapter.MesaAdapter;
import modelo.ItemPedido;
import modelo.Mesa;
import modelo.Pedido;
import modelo.Produto;

public class MainAtendente extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_atendente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String mesa = getIntent().getStringExtra("mesa");
        Toast.makeText(this, mesa, Toast.LENGTH_LONG).show();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainAtendente.this, MainListaProdutos.class);
                startActivity(intent);
            }
        });

        TextView textViewMesa = (TextView) findViewById(R.id.textViewMesa);
        textViewMesa.setText(mesa);

       Produto produto = new Produto(1l, "Coca Cola", 5.0f,"");


        ArrayList<Pedido> pedidos = new ArrayList();
        Pedido pedido = new Pedido();
        pedido.setMesa(new Mesa(1l, "Mesa 1"));
        pedido.setValorTotal(0.00f);

        ItemPedido itemPedido = new ItemPedido(1l, new Date(), 5.40f, 1, produto);

        ArrayList<ItemPedido> itemPedidos = new ArrayList<>();
        itemPedidos.add(itemPedido);

        pedido.setItens(itemPedidos);

        ListView listViewProduto = (ListView) findViewById(R.id.listaproduto);
        listViewProduto.setAdapter(new ItemProdutoAdapter(getApplicationContext(), itemPedidos));
        listViewProduto.setOnItemClickListener(new AdapterView.OnItemClickListener()

        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_atendente, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void clickMyButtonGarcom(View view) {

        AlertDialog Alert;
        Alert = new AlertDialog.Builder(this).create();
        Alert.setTitle("Garçom Solicitado");
        Alert.setMessage("Por favor, aguarde!");
        Alert.show();

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}

