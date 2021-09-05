package com.example.earthquake;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {


    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }
        //find earthquake from the list of earthquake
        Earthquake currentEarthquake = getItem(position);
        TextView mag_ = (TextView) listItemView.findViewById(R.id.magnitude);
        TextView loc_ = (TextView) listItemView.findViewById(R.id.location);
        TextView date_ = (TextView) listItemView.findViewById(R.id.date);
        /**
         * Now set magnitude, location, date as given */
        mag_.setText(currentEarthquake.getmMagnitude());
        loc_.setText(currentEarthquake.getmLocation());
        date_.setText(currentEarthquake.getmDate());

        return listItemView;
    }
}
