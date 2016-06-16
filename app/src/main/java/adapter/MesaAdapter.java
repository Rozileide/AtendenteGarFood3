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

import modelo.Mesa;

/**
 * Created by Rozy Ferreira on 05/05/2016.
 */
public class MesaAdapter extends BaseAdapter{

    ArrayList<Mesa> mesas;
    Context context;
    LayoutInflater inflate;

    public MesaAdapter(Context context, ArrayList<Mesa> mesas){
        this.mesas = mesas;
        this.context = context;
        inflate = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    /**
     * Pega quantas mesas tem
     * @return
     */
    @Override
    public int getCount() {
        return mesas.size();
    }

    @Override
    public Object getItem(int position) {
        return mesas.get(position);
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

        TextView idMesa = (TextView)vi.findViewById(R.id.identificacao_mesa);
        TextView dataAbertura = (TextView)vi.findViewById(R.id.data_abertura);
        TextView valor = (TextView)vi.findViewById(R.id.valor_total); // duration
        ImageView thumb_image=(ImageView)vi.findViewById(R.id.image_status);

        Mesa mesa = mesas.get(position);

        idMesa.setText(mesa.getNome());

        return vi;
    }
}
