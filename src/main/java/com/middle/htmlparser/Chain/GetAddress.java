package com.middle.htmlparser.Chain;

import com.middle.htmlparser.PrivateSpy.PrivateSpy;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetAddress implements Chain{
    private String address = "";
    private Chain nextInChain;
    @Override
    public void setNextChain(Chain chain) {
        nextInChain = chain;
    }

    @Override
    public void search(PrivateSpy spy) throws IOException {
        String contain = spy.getDocument().outerHtml();
        Pattern pattern = Pattern.compile("вул\\. .*, [0-9]*");
        Matcher match = pattern.matcher(contain);
        try {
            if (match.find()) {
                address = match.group(0);
                spy.setAddress(address);
            }
        }
        catch (Exception ex) {
            try {
                String API_KEY = "5610ffe7442d63a7679402fb8245f1ad0dfb481f0eb89ce127ef1c9bc3be3d75";
                String url_query = "SELECT NAME FROM COMPANY WHERE WEBSITE='ucu.edu.ua'";
                String query = URLEncoder.encode(url_query, StandardCharsets.UTF_8);
                URL url = new URL("https://api.peopledatalabs.com/v5/company/search?sql=" + query);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("X-Api-Key", API_KEY);
                connection.connect();
                String text = new Scanner(connection.getInputStream()).useDelimiter("\\Z").next();
                JSONObject jsonObject = new JSONObject(text);
                String whole_address = jsonObject.getJSONArray("data").getJSONObject(0).getString("location");
                spy.setAddress(whole_address);
            }
            catch (Exception exception) {
                spy.setAddress(address);
            }
        }
    }
}
