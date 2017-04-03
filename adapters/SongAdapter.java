package cntt.bkdn.dieuhang.mp3.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import cntt.bkdn.dieuhang.mp3.R;
import cntt.bkdn.dieuhang.mp3.models.Song;

/**
 * Created by PC on 1/6/2017.
 */
public class SongAdapter extends BaseAdapter {
    private List<Song> songs;
    private LayoutInflater layoutInflater;
    private Context context;
    public SongAdapter(Context context, List<Song> songs) {
        this.context=context;
        this.songs = songs;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if(songs==null||songs.isEmpty()){
            return 0;
        }
        else return songs.size();
    }

    @Override
    public Object getItem(int position) {
        return songs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Song song = songs.get(position);
        convertView =layoutInflater.inflate(R.layout.item,null);
        TextView songTitle =(TextView) convertView.findViewById(R.id.song_title);
        songTitle.setText(song.getMusicName());
        TextView artist =(TextView) convertView.findViewById(R.id.artist);
        artist.setText(song.getSinger());
    return convertView;
    }

}

