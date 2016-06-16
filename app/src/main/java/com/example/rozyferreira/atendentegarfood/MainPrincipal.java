package com.example.rozyferreira.atendentegarfood;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import modelo.Produto;

public class MainPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_principal);

        Produto produto = new Produto();
        produto.setNome("Coca cola");
        produto.setValor(4.50f);
        produto.setDescricao("Refrigerante de cola");
        produto.salvar(getApplicationContext());

        Produto produto2 = new Produto();
        produto2.setNome("Pespsi");
        produto2.setValor(4.00f);
        produto2.setDescricao("Refrigerante de cola");
        produto.salvar(getApplicationContext());

        for(Produto produto3 : Produto.listProduto(getApplicationContext()))
        {
                Toast.makeText(getApplicationContext(), produto.toString(), Toast.LENGTH_LONG).show();
        }

    }

    public void clickMyButtonAtendente(View view) {

        Intent intent = new Intent(MainPrincipal.this, LoginAtendente.class);
        startActivity(intent);

    }

    public void clickMyButtonCliente(View view) {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        startActivityForResult(intent, 0);
    }

        public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String contents = intent.getStringExtra("SCAN_RESULT");
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");

                if(!contents.isEmpty()){
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(contents);

                        String mesa = jsonObject.getString("mesa");

                        Intent intentMainAtentente = new Intent(this, MainAtendente.class);
                        intentMainAtentente.putExtra("mesa",mesa);
                        startActivity(intentMainAtentente);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }



   /* {
            Intent pedido = new Intent(MainPrincipal.this, MainAtendente.class);
            startActivity(pedido);

        }*/

        /*AlertDialog Alert;
        Alert = new AlertDialog.Builder(this).create();
        Alert.setTitle("GarFood Cliente, estará disponível na Proxima Versão.");
        Alert.setMessage("Agradecemos desde já sua a preferência, ao nosso aplicativo!");
        Alert.show();*/
    }

