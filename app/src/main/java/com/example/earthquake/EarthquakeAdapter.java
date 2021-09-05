package com.example.earthquake;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
        TextView mag_view = (TextView) listItemView.findViewById(R.id.magnitude);
        TextView loc_view = (TextView) listItemView.findViewById(R.id.location);
        TextView date_view = (TextView) listItemView.findViewById(R.id.date);
        TextView time_view = (TextView) listItemView.findViewById(R.id.time);

          // Create a new Date object from the time in milliseconds of the earthquake
          Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());
         // Format the date string (i.e. "Mar 3, 1984")
          String formattedDate = formatDate(dateObject);
         // Format the time string (i.e. "4:30PM")
          String formattedTime = formatTime(dateObject);
        /**
         * Now set magnitude, location, date as given */
        mag_view.setText(currentEarthquake.getmMagnitude());
        loc_view.setText(currentEarthquake.getmLocation());
        date_view.setText(formattedDate);
        time_view.setText(formattedTime);

        return listItemView;
    }




         /**
       * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
       */
      private String formatDate(Date dateObject) {
          SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
          return dateFormat.format(dateObject);
      }

      /**
       * Return the formatted date string (i.e. "4:30 PM") from a Date object.
       */
      private String formatTime(Date dateObject) {
          SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
          return timeFormat.format(dateObject);
      }
}
