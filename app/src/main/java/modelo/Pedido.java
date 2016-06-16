package modelo;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Rozy Ferreira on 24/05/2016.
 */
public class Pedido {
    private long _id;
    private Mesa mesa;
    private float valorTotal;
    private ArrayList<ItemPedido> itens;

    /*Pedido (int id, Mesa mesa, float valorTotal, ArrayList<ItemPedido> itens){
        this._id=id;
        this.mesa=mesa;
        this.valorTotal=valorTotal;
        this.itens=itens;
    }*/

    public Pedido(){}

    public Pedido(long _id, float valorTotal) {
        this._id = _id;
        this.valorTotal = valorTotal;

    }
    public long get_id() {return _id;}
    public void set_id(long _id) {this._id = _id;}

    public float getValorTotal() {return valorTotal;}

    public void setValorTotal(float valorTotal) {this.valorTotal = valorTotal;}

    public ArrayList<ItemPedido> getItens () {return itens;}
    public void setItens (ArrayList<ItemPedido> itens) {this.itens = itens;}

    public Mesa getMesa() {return mesa;}
    public void setMesa (Mesa mesa) {this.mesa = mesa;}


}
