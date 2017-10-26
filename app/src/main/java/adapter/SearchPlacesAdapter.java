package adapter;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import pt.ispg3814.com.weatherapp.R;

import java.util.List;

import models.GooglePlacesResult;

public class SearchPlacesAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<GooglePlacesResult> show_results;

    public SearchPlacesAdapter() {
    }

    public SearchPlacesAdapter(Activity activity, List<GooglePlacesResult> show_results) {
        this.activity = activity;
        this.show_results = show_results;
    }



    @Override
    public int getCount() {
        return show_results.size();
    }

    @Override
    public Object getItem(int position) {
        return show_results.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null) {
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.simple_places_list_item, null);
        }

        TextView cityTextview = (TextView) convertView.findViewById(R.id.city_textview);
        TextView countryTextview = (TextView) convertView.findViewById(R.id.country_textview);

        GooglePlacesResult item = show_results.get(position);

        cityTextview.setText(item.getCity());
        countryTextview.setText(item.getCountry());

        return convertView;
    }
}
