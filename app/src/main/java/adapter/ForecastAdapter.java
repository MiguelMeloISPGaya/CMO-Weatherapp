package adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.List;

import models.ForecastResult;
import pt.ispg3814.com.weatherapp.R;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {

    private List<ForecastResult> results;
    private int rowLayout;
    private Context context;


    public static class ForecastViewHolder extends RecyclerView.ViewHolder {
        LinearLayout forecastLayout;
        TextView weatherParams;
        TextView dateForecast;
        TextView tempnow;
        TextView tempMin;
        TextView tempMax;
        TextView humidity;
        TextView pressure;
        ImageView icon;


        public ForecastViewHolder(View v) {
            super(v);
            forecastLayout = (LinearLayout) v.findViewById(R.id.forecasts_layout);
            weatherParams = (TextView) v.findViewById(R.id.Weather_params);
            dateForecast = (TextView) v.findViewById(R.id.Date_forecast);
            tempnow = (TextView) v.findViewById(R.id.temp_now);
            tempMin = (TextView) v.findViewById(R.id.temp_min);
            tempMax = (TextView) v.findViewById(R.id.temp_max);
            humidity = (TextView) v.findViewById(R.id.humidity);
            pressure = (TextView) v.findViewById(R.id.pressure);
            icon = (ImageView) v.findViewById(R.id.weather_icon);
        }
    }

    public ForecastAdapter(List<ForecastResult> results, int rowLayout, Context context) {
        this.results = results;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public ForecastAdapter.ForecastViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ForecastViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ForecastViewHolder holder, final int position) {
        holder.weatherParams.setText(results.get(position).getWeatherResultList().get(0).getDescription());
        holder.dateForecast.setText(results.get(position).getDate_of_forecast());
        holder.tempnow.setText("Atual : "+String.valueOf(results.get(position).getTemps().getTemperature())+"ºC");
        holder.tempMin.setText(String.valueOf("Min : "+results.get(position).getTemps().getMinimum_temperature())+" ºC");
        holder.tempMax.setText(String.valueOf("Máx : "+results.get(position).getTemps().getMaximum_temperature())+" ºC");
        holder.humidity.setText(String.valueOf("Taxa Humidade:"+results.get(position).getTemps().getHumidity())+"%");
        holder.pressure.setText(String.valueOf("Pressão : "+results.get(position).getTemps().getPressure())+" hPa");
        holder.icon.setImageDrawable(getDrawableFromIconName(results.get(position).getWeatherResultList().get(0).getIcon()));
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    private Drawable getDrawableFromIconName(String icon_name) {
        Drawable toReturn;
        Log.d("XPTO",icon_name);
        switch (icon_name) {
            case "01d":
                toReturn = context.getDrawable(R.drawable.ic_sunny);
                break;
            case "01n":
                toReturn = context.getDrawable(R.drawable.ic_moon);
                break;
            case "02d":
                toReturn = context.getDrawable(R.drawable.ic_cloudy_day);
                break;
            case "02n":
                toReturn = context.getDrawable(R.drawable.ic_cloudy_night);
                break;
            case "03d":
            case "03n":
                toReturn = context.getDrawable(R.drawable.ic_clouds);
                break;
            case "04d":
            case "04n":
                toReturn = context.getDrawable(R.drawable.ic_broken_clouds);
                break;
            case "09d":
            case "09n":
                toReturn = context.getDrawable(R.drawable.ic_alot_of_rain);
                break;
            case "10d":
                toReturn = context.getDrawable(R.drawable.ic_day_rain);
                break;
            case "10n":
                toReturn = context.getDrawable(R.drawable.ic_night_rain);
                break;
            case "11d":
                toReturn = context.getDrawable(R.drawable.ic_storm_day);
                break;
            case "11n":
                toReturn = context.getDrawable(R.drawable.ic_storm_night);
                break;
            case "13d":
                toReturn = context.getDrawable(R.drawable.ic_day_snow);
                break;
            case "13n":
                toReturn = context.getDrawable(R.drawable.ic_night_snow);
                break;
            case "50d":
            case "50n":
                toReturn = context.getDrawable(R.drawable.ic_haze);
                break;
            default:
                toReturn = context.getDrawable(R.drawable.ic_na);
                break;
        }

        return toReturn;
    }
}