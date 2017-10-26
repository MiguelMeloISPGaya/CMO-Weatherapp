package pt.ispg3814.com.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adapter.ForecastAdapter;
import models.CityResult;
import models.ForecastResponse;
import models.ForecastResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utils.OpenWeatherApiClient;
import utils.OpenWeatherApiInterface;
import utils.Utilities;

public class ForecastActivity extends AppCompatActivity {

    SearchView mSearchView;
    private static final String TAG = ForecastActivity.class.getSimpleName();
    private ArrayList<Integer> filters;

    private final static String API_KEY = "b46a61e29dbbb32035b71656573d5697";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        String query_params = getIntent().getStringExtra("City")+" "+getIntent().getStringExtra("Country");
        String filter = getIntent().getStringExtra("Filter");
        filters = Utilities.getWeatherFromFilter(filter);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.forecasts_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        OpenWeatherApiInterface apiService = OpenWeatherApiClient.getClient().create(OpenWeatherApiInterface.class);

        Call<ForecastResponse> call = apiService.getForecastForCity(query_params, "pt", "metric" ,API_KEY);

        call.enqueue(new Callback<ForecastResponse>() {

            @Override
            public void onResponse(Call<ForecastResponse> call, Response<ForecastResponse> response) {
                TextView city_label = (TextView) findViewById(R.id.city_label_text);
                CityResult city = response.body().getCityResult();
                city_label.setText(city.getName()+" "+city.getCountry_code());
                List<ForecastResult> results = response.body().getForecastresult();
                List<ForecastResult> filteredResults = new ArrayList<ForecastResult>();
                for (ForecastResult currentResult : results) {
                    if(filters.size() == 0) {
                        filteredResults.add(currentResult);
                    }
                    else if (filters.contains(currentResult.getWeatherResultList().get(0).getId())) {
                        filteredResults.add(currentResult);
                    }
                }
                recyclerView.setAdapter(new ForecastAdapter(filteredResults, R.layout.list_forecast_item, getApplicationContext()));
                Log.d(TAG, "Number of results received: ");
            }

            @Override
            public void onFailure(Call<ForecastResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }


       /* DatabaseHandler db = new DatabaseHandler(this);

        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.create_city(new City("Porto", "Portugal",1,1));
        db.create_city(new City("Porto", "Brazil",1,1));

        // Reading all contacts
        Log.d("Reading: ", "Reading all cities..");
        List<City> cities = new ArrayList<City>();
        cities = db.get_cities_by_name("Porto");




        //Read all cities in database
        for (City current_city:cities)
        {
            Log.d("lista cidades",current_city.getname()+ " " +current_city.getCountry());
        }

        Log.d("Terminando", "Ending");*/

//        GooglePlacesApiClient.getCitiesByName("porto", new JsonHttpResponseHandler()
//        {
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONArray response)
//            {
//                Log.d("RESULT ARRAY", "is HERE!");
//            }
//
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONObject response)
//            {
//                Log.d("RESULT OBJECT", "is HERE!");
//                ArrayList<String> results = new ArrayList();
//                try
//                {
//                    JSONArray predictions = response.getJSONArray("predictions");
//                    Log.d("dsadasdsa","dsadad");
//                } catch (JSONException e)
//                {
//                    e.printStackTrace();
//                }
//            }
//        });
}
