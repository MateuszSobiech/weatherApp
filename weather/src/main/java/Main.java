import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {

        DecimalFormat df = new DecimalFormat();

        URL urlWeather = new URL("http://api.openweathermap.org/data/2" +
                ".5/weather?q=London&appid=55b7bce44b262858d3201b409b5dcd65");
        InputStreamReader reader = new InputStreamReader(urlWeather.openStream());

        JsonObject jsonObject = new JsonParser().parse(reader).getAsJsonObject();
        String city = jsonObject.get("name").getAsString();

        double temp = jsonObject.getAsJsonObject("main").get("temp").getAsDouble();
        String format = df.format(temp - 273.15);

        String weather = jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").toString();

        //String mainW = weather.get(0).getAsJsonObject().get("main").toString();
        System.out.println("---------------------------------");
        System.out.println(city + " = " + format + " ℃ // " + weather);
    }
}
