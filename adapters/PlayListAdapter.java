package cntt.bkdn.dieuhang.mp3.adapters;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cntt.bkdn.dieuhang.mp3.R;
import cntt.bkdn.dieuhang.mp3.models.NewList;

/**
 * Created by PC on 3/21/2017.
 */

public class PlayListAdapter  extends BaseAdapter {
    private List<NewList> playlists;
    private LayoutInflater layoutInflater;
    private Context context;
    public SparseBooleanArray mCheckStates;
    List<NewList> list= list= new ArrayList<>();


    public PlayListAdapter(Context context, List<NewList> playlists) {
        this.context=context;
        this.playlists = playlists;
        layoutInflater=LayoutInflater.from(context);
        mCheckStates = new SparseBooleanArray(list.size());

    }

    @Override
    public int getCount() {
        if(playlists==null||playlists.isEmpty()){
            return 0;
        }
        else return playlists.size();
    }

    @Override
    public Object getItem(int position) {
        return playlists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final NewList playList = playlists.get(position);
        convertView =layoutInflater.inflate(R.layout.item_playlist,null);
        TextView playListName =(TextView) convertView.findViewById(R.id.playlist_name);
        playListName.setText(playList.getName());
        CheckBox checkBox =(CheckBox) convertView.findViewById(R.id.check_box);
        checkBox.setTag(position);
        checkBox.setChecked(mCheckStates.get(position, false));
        checkBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) this);

        return convertView;
    }
    public boolean isChecked(int position) {
        return mCheckStates.get(position, false);
    }

    public void setChecked(int position, boolean isChecked) {
        mCheckStates.put(position, isChecked);

    }

}

