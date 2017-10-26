package pt.ispg3814.com.weatherapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import adapter.SearchPlacesAdapter;
import models.GooglePlacesResult;
import cz.msebera.android.httpclient.Header;
import utils.GooglePlacesApiClient;

public class MainActivity extends AppCompatActivity {

    SearchView mSearchview;
    SearchPlacesAdapter mSearchViewAdapter;
    ListView mResultsList;
    Spinner mSpinner;
    long lastSearchTime = -1;
    List<GooglePlacesResult> places_list = new ArrayList<>();
    private static Context mContext;
    String weatherFilter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity.setmContext(this);

        mSearchview = (SearchView) findViewById(R.id.searchview_forecast);
        mSearchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(query.length() > 2) {
                    long actualSearchTime = (Calendar.getInstance().getTimeInMillis());
                    if (actualSearchTime > lastSearchTime + 1000) {
                        lastSearchTime = actualSearchTime;
                        searchGoogleRequest(query);
                        mSearchview.clearFocus();
                    }
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                if(query.length() > 2) {
                    searchGoogleRequest(query);
                }
                return true;
            }
        });

        mResultsList = (ListView) findViewById(R.id.list_places);
        mSearchViewAdapter = new SearchPlacesAdapter(this, places_list);
        mResultsList.setAdapter(mSearchViewAdapter);
        mSpinner = (Spinner) findViewById(R.id.weather_param_spinner);
        mSpinner.setPrompt("(Opcional) Estado tempo");
        ArrayAdapter<CharSequence> arrAdapter = ArrayAdapter.createFromResource(this, R.array.weather_params, R.layout.support_simple_spinner_dropdown_item);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                weatherFilter = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mSpinner.setAdapter(arrAdapter);

        mResultsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                GooglePlacesResult current_item = (GooglePlacesResult) parent.getAdapter().getItem(position);
                Intent intent = new Intent(MainActivity.getmContext(), ForecastActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("City",current_item.getCity());
                intent.putExtra("Country",current_item.getCountry());
                intent.putExtra("Filter",weatherFilter);
                MainActivity.getmContext().startActivity(intent);
            }
        });
    }

    private void searchGoogleRequest(String query) {
        places_list.clear();
        GooglePlacesApiClient.getCitiesByName(query, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try
                {
                    JSONArray predictions = response.getJSONArray("predictions");
                    GooglePlacesResult newResult;
                    JSONObject currentPrediction;

                    for(int i = 0 ; i < predictions.length(); i++) {

                        currentPrediction = predictions.getJSONObject(i);
                        newResult = new GooglePlacesResult();
                        newResult.setCity(currentPrediction.getJSONObject("structured_formatting").getString("main_text"));
                        newResult.setCountry(currentPrediction.getJSONObject("structured_formatting").has("secondary_text") ? currentPrediction.getJSONObject("structured_formatting").getString("secondary_text") : "");
                        places_list.add(newResult);
                    }
                } catch (JSONException e)
                {
                    e.printStackTrace();
                }
                // there were changes to the list content, lets notify the UI adapter so it refreshes
                mSearchViewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }

    public static Context getmContext() {
        return mContext;
    }

    public static void setmContext(Context mContext) {
        MainActivity.mContext = mContext;
    }
}
