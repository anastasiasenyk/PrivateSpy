package com.middle.htmlparser.Media;
import com.middle.htmlparser.PrivateSpy.PrivateSpy;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.jsoup.nodes.Document;

import java.io.IOException;

public class GetIcon implements GetImg {
    @Override
    public String search(PrivateSpy spy) throws IOException, JSONException {
//        implement logic of searching for Icon
        String domain = spy.getDomain().getDomainName();
        String API_KEY = "2i9AEGZOrYE4I6cCGhLG8erzAZIqlfZbtm8zDBxL4Ok=";
        String query = URLEncoder.encode(domain, StandardCharsets.UTF_8);
        URL url = new URL("https://api.brandfetch.io/v2/brands/" + query);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
        connection.connect();
        String text = new Scanner(connection.getInputStream()).useDelimiter("\\Z").next();
        JSONObject jsonObject = new JSONObject(text);
        try {
            return jsonObject.getJSONArray("logos").getJSONObject(0).getJSONArray("formats").getJSONObject(0).getString("src");
        }
        catch (Exception x) {
            return "";
        }
    }
}
