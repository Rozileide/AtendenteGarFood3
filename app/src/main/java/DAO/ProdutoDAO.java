package DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import modelo.Produto;

/**
 * Created by Rozy Ferreira on 24/05/2016.
 */
public class ProdutoDAO extends OpenSqliteHelper {

    public ProdutoDAO(Context context) {
        super(context);
    }

    public static String TABLE = "produto";
    public static String COLUNA_ID = "id";
    public static String COLUNA_NOME = "nome";
    public static String COLUNA_DESCRICAO = "descricao";
    public static String COLUNA_VALOR = "valor";

    public static String CRIA_PRODUTO = "create table if not exists " + TABLE +" ( "+
                                        COLUNA_ID +" integer primary key, "+
                                        COLUNA_NOME+" text," +
                                        COLUNA_DESCRICAO + " text," +
                                        COLUNA_VALOR + " real)";

    /**
     * salva um produto no banco de dados
     * @param produto
     * @return
     */
    public Produto inserirProduto(Produto produto){
        //Aqui estou criando uma estrutura de dados que vai conter os dados a serem armazenados.
        ContentValues contentValues = new ContentValues();
        //indico o nome do produto
        contentValues.put(COLUNA_NOME, produto.getNome());
        //indico a descricao do produto
        contentValues.put(COLUNA_DESCRICAO, produto.getDescricao());
        contentValues.put(COLUNA_VALOR, produto.getValor());

        //peco para o android salvar e se tiver sucesso ele retorna o id da linha senao retorna -1.
        long id = getWritableDatabase().insertOrThrow(TABLE,null,contentValues);

        produto.set_id(id);

        return produto;
    }

    public ArrayList<Produto> listProduto(){
        ArrayList<Produto> produtos = new ArrayList<>();


        //faco a consulta e retorno para resultado como um cursor
        Cursor curso = getReadableDatabase().rawQuery("select "+COLUNA_ID+", "+COLUNA_NOME+", " +
                ""+COLUNA_DESCRICAO+", "+COLUNA_VALOR +" from "+ TABLE, null);

        //movimento o cursor para a primeira posicao
        curso.moveToFirst();

        //enquanto o cursor nao chegar na ultima posicao, retirar os dados do cursor e adicionar na lista de produto
        while(!curso.isLast()){
            Produto produto = new Produto();
            produto.set_id(curso.getLong(curso.getColumnIndex(COLUNA_ID)));
            produto.setNome(curso.getString(curso.getColumnIndex(COLUNA_NOME)));
            produto.setDescricao(curso.getString(curso.getColumnIndex(COLUNA_DESCRICAO)));
            produto.setValor(curso.getFloat(curso.getColumnIndex(COLUNA_VALOR)));
            produtos.add(produto);

            curso.moveToNext();
        }

        return produtos;

    }
}
