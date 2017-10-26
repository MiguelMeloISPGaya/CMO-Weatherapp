package utils;


import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class GooglePlacesApiClient {

    private static final String BASE_URL = "https://maps.googleapis.com/maps/api";
    private static final String api_key = "AIzaSyA5jzkPq8qMaRcI_gOyEo9R3qH0NpN4fsk";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void getCitiesByName(String query, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl("/place/autocomplete/json?input="+query+"&types=geocode"), responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl + "&key=" + api_key;
    }
}
