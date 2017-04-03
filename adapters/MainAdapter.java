package cntt.bkdn.dieuhang.mp3.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import cntt.bkdn.dieuhang.mp3.models.Item;
import cntt.bkdn.dieuhang.mp3.R;

/**
 * Created by PC on 1/8/2017.
 */

public class MainAdapter extends BaseAdapter{
    private ArrayList<Item> items;
    private LayoutInflater layoutInflater;
    private Context context;
    public MainAdapter(Context context, ArrayList<Item> items) {
        this.context=context;
        this.items = items;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if(items==null||items.isEmpty()){
            return 0;
        }
        else return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Item item = items.get(position);
        convertView =layoutInflater.inflate(R.layout.item_main,null);
       ImageView imageView =(ImageView) convertView.findViewById(R.id.imageView);
        TextView name =(TextView) convertView.findViewById(R.id.name);
        TextView total =(TextView) convertView.findViewById(R.id.total);
        name.setText(item.getName());
        total.setText(item.getTotal());
        imageView.setImageResource(item.getImage());
        return convertView;
    }

}
