package com.test.hlinjue.hlinjueservice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by Administrator on 7/8/2559.
 */
public class ServiceAdapter extends BaseAdapter{

    //Explicit
    private Context context;
    private String[] iconStrings, titleStrings,
    statusStrings, detailStrings;

    public ServiceAdapter(Context context,
                          String[] iconStrings,
                          String[] titleStrings,
                          String[] statusStrings,
                          String[] detailStrings) {
        this.context = context;
        this.iconStrings = iconStrings;
        this.titleStrings = titleStrings;
        this.statusStrings = statusStrings;
        this.detailStrings = detailStrings;
    }

    @Override
    public int getCount() {
        return iconStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.service_listview, parent, false);

        // ิ bind widgett
        ImageView iconImageView = (ImageView) view.findViewById(R.id.imageView8);
        TextView titleTextView = (TextView) view.findViewById(R.id.textView9);
        ImageView statusImageView = (ImageView) view.findViewById(R.id.imageView9);
        TextView detailTextView = (TextView) view.findViewById(R.id.textView10);

        // show view

        Picasso.with(context)
                .load(iconStrings[position])
                .resize(120, 120)
                .into(iconImageView);
        titleTextView.setText(titleStrings[position]);
        detailTextView.setText(detailStrings[position]);

        switch (Integer.parseInt(statusStrings[position])) {

            case 0 :
                statusImageView.setImageResource(R.drawable.myfalse);
                break;
            case 1 :
                statusImageView.setImageResource(R.drawable.mytrue);
                break;


        }


        return view;
    }
}
