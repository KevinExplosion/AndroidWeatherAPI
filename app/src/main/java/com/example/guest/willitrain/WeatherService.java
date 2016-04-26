package com.example.guest.willitrain;


import android.util.Log;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import static com.example.guest.willitrain.Constants.WEATHER_CITY_QUERY_PARAMETER;

/**
 * Created by Guest on 4/25/16.
 */
public class WeatherService {

    public static void findForecast(String location, Callback callback) {
        Log.d("LOCATION", location);
        String WEATHER_API = Constants.WEATHER_API;

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.WEATHER_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.WEATHER_CITY_QUERY_PARAMETER, location);
        urlBuilder.addQueryParameter("appid", WEATHER_API);
        Log.d("tag", ""+urlBuilder);

        String url = urlBuilder.build().toString();

        Request request= new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
