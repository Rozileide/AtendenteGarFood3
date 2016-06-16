package modelo;

import java.util.Date;

/**
 * Created by Rozy Ferreira on 06/06/2016.
 */
public class ItemPedido {

    private long _id;
    private Date date;
    private float preco;
    private int quantidade;
    private Produto produto;
    private Pedido pedido;

    public ItemPedido(long _id, Date date, float valor, int quantidade, Produto produto) {
        this._id = _id;
        this.date = date;
        this.preco = valor;
        this.quantidade = quantidade;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getPreco() {return preco;}

    public void setPreco(float preco) {this.preco = preco;}

    public int getQuantidade() {return quantidade;}

    public void setQuantidade(int quantidade) {this.quantidade = quantidade;}

    public Produto getProduto(){return produto;}
    private void setProduto(Produto produto){this.produto = produto;}

    public Pedido getPedido(){return pedido;}
    public void setPedido(Pedido pedido){this.pedido = pedido;}



}
