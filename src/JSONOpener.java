import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class JSONOpener {
    private static final String urlServer = "https://danepubliczne.imgw.pl/api/data/synop.json";

    public static void getDataFromJSONFile(){
        BufferedReader bufferedReader;
        try
        {
            URL url = new URL(urlServer);
            bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder string = new StringBuilder();
            String jsonData;

            while ((jsonData = bufferedReader.readLine()) != null)
                string.append(jsonData);

            JSONArray stationJsonArray = new JSONArray(string.toString());
            JSONObject station = stationJsonArray.getJSONObject(59); // weather station with index 59
            System.out.println(station);
        }
        catch(IOException | JSONException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        getDataFromJSONFile();
    }
}
