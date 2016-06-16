package modelo;

import android.content.Context;

import java.util.ArrayList;

import DAO.ProdutoDAO;

/**
 * Created by Rozy Ferreira on 24/05/2016.
 */
public class Produto {
    private long _id;
    private String nome;
    private String descricao;
    private float valor;

    public Produto(){}

    public Produto(long _id, String nome, float valor, String descricao) {
        this._id = _id;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {return valor;}

    public void setValor(float valor) {this.valor = valor;}

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void salvar(Context context){
        ProdutoDAO produtoDAO = new ProdutoDAO(context);
        produtoDAO.inserirProduto(this);
    }

    public static ArrayList<Produto> listProduto(Context context){
        ProdutoDAO produtoDAO = new ProdutoDAO(context);
        return produtoDAO.listProduto();
    }

    @Override
    public String toString() {
        return "Produto{" +
                "_id=" + _id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                '}';
    }
}
