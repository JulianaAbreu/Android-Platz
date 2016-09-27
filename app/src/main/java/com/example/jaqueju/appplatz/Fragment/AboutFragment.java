package com.example.jaqueju.appplatz.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.jaqueju.appplatz.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {


    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root_View = inflater.inflate(R.layout.fragment_list2, container, false);
        GridView gridview = (GridView) root_View.findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(getActivity()));

        return inflater.inflate(R.layout.fragment_about, container, false);
    }

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;
        private Integer[] mThumbIds = {
                R.drawable.ctg_festival, R.drawable.ctg_festival,
                R.drawable.ctg_festival, R.drawable.ctg_festival,
                R.drawable.ctg_festival, R.drawable.ctg_festival,
                R.drawable.ctg_festival, R.drawable.ctg_festival,
                R.drawable.ctg_festival, R.drawable.ctg_festival,
                R.drawable.ctg_festival, R.drawable.ctg_festival,
                R.drawable.ctg_festival, R.drawable.ctg_festival,
                R.drawable.ctg_festival, R.drawable.ctg_festival,
                R.drawable.ctg_festival, R.drawable.ctg_festival,
                R.drawable.ctg_festival, R.drawable.ctg_festival,
                R.drawable.ctg_festival, R.drawable.ctg_festival
        };

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return mThumbIds[position];
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }
    }

}
