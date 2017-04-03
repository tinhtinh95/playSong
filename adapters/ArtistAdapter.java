package cntt.bkdn.dieuhang.mp3.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import cntt.bkdn.dieuhang.mp3.R;
import cntt.bkdn.dieuhang.mp3.models.Song;

/**
 * Created by PC on 1/9/2017.
 */

public class ArtistAdapter  extends BaseAdapter {
    private ArrayList<Song> artists;
    private LayoutInflater layoutInflater;
    private Context context;
    public ArtistAdapter(Context context, ArrayList<Song> artists) {
        this.context=context;
        this.artists = artists;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if(artists==null||artists.isEmpty()){
            return 0;
        }
        else return artists.size();
    }

    @Override
    public Object getItem(int position) {
        return artists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Song song = artists.get(position);
        convertView =layoutInflater.inflate(R.layout.artist_item,null);
        TextView artistName =(TextView) convertView.findViewById(R.id.artist_name);
        artistName.setText(song.getSinger());
        return convertView;
    }

}
