package com.example.jaqueju.appplatz.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jaqueju.appplatz.R;

/**
 * Created by 15153818 on 20/09/2016.
 */
public class EventosCategoriaAdapter  extends ArrayAdapter<String>{
    private Context con;
    private int lastPosition = -1;
    ImageView iv_gameimages;
    TextView tv_gamenames;
    TextView tv_releasdate;
    TextView tv_gameplateform;

    String games_arr[] = {

            "Call of Duty Black Ops III",
            "Assassin's Creed Syndicate",
            "Fallout 4",
            "Need For Speed",
            "Rise of the Tomb Raider",
            "Mafia III",
            "Tom Clancy's The Division",
            "Just Cause 3"
    };

    int images_arr[] = {

            R.drawable.evento,
            R.drawable.newyork,
            R.drawable.newyork,
            R.drawable.newyork,
            R.drawable.newyork,
            R.drawable.newyork,
            R.drawable.newyork,
            R.drawable.newyork
    };

    String releaseDate_arr[] = {

            "Coming Nov 6, 2015",
            "Coming Oct 23, 2015",
            "Coming Nov 10, 2015",
            "Coming Nov 3, 2015",
            "Coming Nov 10, 2015",
            "Coming Dec 31, 2016",
            "Coming Mar 8, 2016",
            "Coming Dec 1, 2015"
    };


    String plateform_arr[] = {

            "Dia 02 de Dezembro de 2016",
            "Dia 02 de Dezembro de 2016",
            "Dia 02 de Dezembro de 2016",
            "Dia 02 de Dezembro de 2016",
            "Dia 02 de Dezembro de 2016",
            "Dia 02 de Dezembro de 2016",
            "Dia 02 de Dezembro de 2016",
            "Dia 02 de Dezembro de 2016"
    };
    public EventosCategoriaAdapter(Context context, int resource, String[] objects) {
        super(context, resource, objects);
        this.con = context;
        this.games_arr = objects;
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) con.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.list_item_template,parent,false);

        iv_gameimages = (ImageView) row.findViewById(R.id.game_image);
        iv_gameimages.setImageResource(images_arr[position]);

        tv_gamenames = (TextView) row.findViewById(R.id.txt_game_name);
        tv_gamenames.setText(games_arr[position]);

        tv_releasdate = (TextView) row.findViewById(R.id.txt_relase_date);
        tv_releasdate.setText(releaseDate_arr[position]);


        tv_gameplateform = (TextView) row.findViewById(R.id.txt_plateform);
        tv_gameplateform.setText(plateform_arr[position]);

        Animation animation = AnimationUtils.loadAnimation(getContext(), (position > lastPosition) ?     R.anim.up_from_bottom : R.anim.down_from_top);
        row.startAnimation(animation);
        lastPosition = position;

        return row;
    }
}
