package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rozyferreira.atendentegarfood.R;

import java.util.ArrayList;

import modelo.ItemPedido;
import modelo.Mesa;

/**
 * Created by Rozy Ferreira on 05/05/2016.
 */
public class ItemProdutoAdapter extends BaseAdapter{

    ArrayList<ItemPedido> itemPedido;
    Context context;
    LayoutInflater inflate;

    public ItemProdutoAdapter(Context context, ArrayList<ItemPedido> itemPedido){
        this.itemPedido = itemPedido;
        this.context = context;
        inflate = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return itemPedido.size();
    }

    @Override
    public Object getItem(int position) {
        return itemPedido.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi= convertView;
        if(convertView==null)
            vi = inflate.inflate(R.layout.item_mesa, null);

        TextView produto = (TextView)vi.findViewById(R.id.identificacao_produto);
        TextView quantidade = (TextView)vi.findViewById(R.id.quantidade);
        TextView preco = (TextView)vi.findViewById(R.id.preco);
        TextView valorTotal = (TextView)vi.findViewById(R.id.valor_total);
        ImageView thumb_image=(ImageView)vi.findViewById(R.id.image_status);

        ItemPedido itemPedido = (ItemPedido) getItem(position);

       // produto.setText(itemPedido.getProduto().getNome());

        return vi;
    }
}
