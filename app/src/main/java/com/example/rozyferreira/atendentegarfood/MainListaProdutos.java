package com.example.rozyferreira.atendentegarfood;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

import adapter.ItemProdutoAdapter;
import modelo.ItemPedido;
import modelo.Mesa;
import modelo.Pedido;
import modelo.Produto;

public class MainListaProdutos extends AppCompatActivity {

    Integer Total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_lista_produtos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageButton fab = (ImageButton) findViewById(R.id.btSalvar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainListaProdutos.this, MainAtendente.class);
                startActivity(intent);
            }
        });

        ImageButton mais = (ImageButton) findViewById(R.id.btMais);
        final EditText Valor = (EditText)findViewById(R.id.btValor);
        mais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Total = Integer.parseInt(Valor.getText().toString())+1;

                Valor.setText(Total.toString());
            }
        });

        ImageButton menos = (ImageButton) findViewById(R.id.btMenos);
        final EditText Valor2 = (EditText)findViewById(R.id.btValor);
        menos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Total = Integer.parseInt(Valor2.getText().toString())-1;

                Valor2.setText(Total.toString());
            }
        });

        Produto produto = new Produto(1l, "Coca Cola", 5.0f,"");
        Produto produto1 = new Produto(2l, "Porção: Batata Frita", 14.0f,"");
        Produto produto2 = new Produto(3l, "Cerveja", 3.5f,"");
        Produto produto3 = new Produto(4l, "Porção: Batata Frita com Baicon", 28.0f,"");
        Produto produto4 = new Produto(5l, "Agua Mineral", 2.80f,"");
        Produto produto5 = new Produto(6l, "Suco Del Vale", 4.0f,"");
        Produto produto6 = new Produto(7l, "Pizza", 37.0f,"");
        Produto produto7 = new Produto(8l, "Suco Natural", 8.30f,"");
        Produto produto8 = new Produto(9l, "Espetinho", 5.0f,"");
        Produto produto9 = new Produto(10l, "Sorvete de Palito", 5.0f,"");




        ArrayList<Pedido> pedidos = new ArrayList();
        Pedido pedido = new Pedido();
        pedido.setMesa(new Mesa(1l, "Mesa 1"));
        pedido.setValorTotal(0.00f);

        ItemPedido itemPedido = new ItemPedido(1l, new Date(), 5.40f, 1, produto);
        ItemPedido itemPedido1 = new ItemPedido(1l, new Date(), 5.40f, 1, produto1);
        ItemPedido itemPedido2 = new ItemPedido(1l, new Date(), 5.40f, 1, produto2);
        ItemPedido itemPedido3 = new ItemPedido(1l, new Date(), 5.40f, 1, produto3);
        ItemPedido itemPedido4 = new ItemPedido(1l, new Date(), 5.40f, 1, produto4);
        ItemPedido itemPedido5 = new ItemPedido(1l, new Date(), 5.40f, 1, produto5);
        ItemPedido itemPedido6 = new ItemPedido(1l, new Date(), 5.40f, 1, produto6);
        ItemPedido itemPedido7 = new ItemPedido(1l, new Date(), 5.40f, 1, produto7);
        ItemPedido itemPedido8 = new ItemPedido(1l, new Date(), 5.40f, 1, produto8);
        ItemPedido itemPedido9 = new ItemPedido(1l, new Date(), 5.40f, 1, produto9);

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


}
