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

public class AlbumAdapter extends BaseAdapter{
    private ArrayList<Song> albums;
    private LayoutInflater layoutInflater;
    private Context context;
    public AlbumAdapter(Context context, ArrayList<Song> albums) {
        this.context=context;
        this.albums = albums;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if(albums==null||albums.isEmpty()){
            return 0;
        }
        else return albums.size();
    }

    @Override
    public Object getItem(int position) {
        return albums.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Song song = albums.get(position);
        convertView =layoutInflater.inflate(R.layout.album_item,null);
        TextView albumTitle =(TextView) convertView.findViewById(R.id.album_name);
                albumTitle.setText(song.getAlbumName());
        return convertView;
    }

}
