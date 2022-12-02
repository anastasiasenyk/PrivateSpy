package com.middle.htmlparser.Media;
import com.middle.htmlparser.PrivateSpy.PrivateSpy;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import org.jsoup.nodes.Document;

public class GetLogo implements GetImg{
    @Override
    public String search(PrivateSpy spy)  throws IOException, JSONException{
        String domain = spy.getDomain();
        String API_KEY = "2i9AEGZOrYE4I6cCGhLG8erzAZIqlfZbtm8zDBxL4Ok=";
        domain = "lnu.edu.ua";
        String query = URLEncoder.encode(domain, StandardCharsets.UTF_8);
        URL url = new URL("https://api.brandfetch.io/v2/brands/" + query);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
        connection.connect();
        String text = new Scanner(connection.getInputStream()).useDelimiter("\\Z").next();
        JSONObject jsonObject = new JSONObject(text);
        try {
            return jsonObject.getJSONArray("logos").getJSONObject(1).getJSONArray("formats").getJSONObject(1).getString("src");
        }
        catch (Exception x) {
            return "";
        }
    }
}
