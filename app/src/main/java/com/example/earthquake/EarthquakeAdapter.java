package com.example.earthquake;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    //used for splitting string
    private static final String LOCATION_SEPARATOR = " of ";


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

         // Find the earthquake at the given position in the list of earthquakes
        Earthquake currentEarthquake = getItem(position);



        TextView mag_view = (TextView) listItemView.findViewById(R.id.magnitude);
        TextView loc_offset = (TextView) listItemView.findViewById(R.id.location_offset);
        TextView loc_primary = (TextView) listItemView.findViewById(R.id.primary_location);
        TextView date_view = (TextView) listItemView.findViewById(R.id.date);
        TextView time_view = (TextView) listItemView.findViewById(R.id.time);

        /**
         * Formatting date and time Using Simple time class*/
        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);

        /**
         * Formatting magnitude value as we can see that it is in double format*/
        double double_magnitude = currentEarthquake.getmMagnitude();
        String magnitude = formatMagnitude(double_magnitude);

        /**
         * Convert whole location into 2 parts such that 1 is location offset
         * and another is primary location*/
        String originalLocation = currentEarthquake.getmLocation();
        String locOff = getlocationOffset(originalLocation);
        String locP = getPrimaryLocation(originalLocation);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) mag_view.getBackground();
        int magnitude1Color = ContextCompat.getColor(getContext(), R.color.magnitude1);
        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getmMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        /**
         * Now set magnitude, location, date as given */
        mag_view.setText(magnitude);
        loc_offset.setText(locOff);
        loc_primary.setText(locP);
        date_view.setText(formattedDate);
        time_view.setText(formattedTime);

        return listItemView;
    }


    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object
     * Return type = string
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     * Return type = string
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    /**
     * Return the formatted double value (i.e. 2.3) from DecimatFormat object
     * Return type = string
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }


    /**
     * Return location offset of string
     */
    private String getlocationOffset(String originalLoc) {
        if (originalLoc.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLoc.split(LOCATION_SEPARATOR);
            String offset_part = parts[0] + LOCATION_SEPARATOR;
            return offset_part;
        } else {
            String locationOffset = getContext().getString(R.string.location_offset) + LOCATION_SEPARATOR;
            return locationOffset;
        }

    }

    /**
     * Return location primary of string
     */
    private String getPrimaryLocation(String originalLoc) {
        if (originalLoc.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLoc.split(LOCATION_SEPARATOR);
            String primary_location = parts[1];
            return primary_location;
        } else {
            String primary_location = getContext().getString(R.string.location_offset);
            return primary_location;
        }
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
