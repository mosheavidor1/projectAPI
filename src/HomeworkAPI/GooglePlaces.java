package HomeworkAPI;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.IOException;

public class GooglePlaces {

        public static void main(String[] args) throws IOException, JSONException {

            // use OKHttp client to create the connection and retrieve data
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                   // .url("https://maps.googleapis.com/maps/api/place/textsearch/json?query=restaurants+in+Jerusalem&key=AIzaSyCvAHp_krsONsNZ3bEphkqXxuy_IKMJZ8g")
                    .url("https://maps.googleapis.com/maps/api/place/textsearch/json?query=restaurants+in+tel.aviv&key=AIzaSyCvAHp_krsONsNZ3bEphkqXxuy_IKMJZ8g")
                    .build();
            Response response = client.newCall(request).execute();
            String jsonData = response.body().string();
            // parse JSON
            JSONObject mainJsonObject = new JSONObject(jsonData);
            // get Json object
            JSONArray resultsJson = mainJsonObject.getJSONArray("results");
            JSONObject mainJson=resultsJson.getJSONObject(0);

            JSONObject geometry = mainJson.getJSONObject("geometry");
            JSONObject location = geometry.getJSONObject("location");

            System.out.println( location.get("lat").toString() + " " +location.get("lng").toString());
        }
    }


