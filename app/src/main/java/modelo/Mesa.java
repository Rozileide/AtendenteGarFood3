package modelo;

/**
 * Created by Rozy Ferreira on 05/05/2016.
 */
public class Mesa {

    private long _id;
    private String nome;

    public Mesa(){}

    public Mesa(long _id, String nome) {
        this._id = _id;
        this.nome = nome;
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
}
