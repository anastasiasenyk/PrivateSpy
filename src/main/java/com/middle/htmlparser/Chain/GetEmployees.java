package com.middle.htmlparser.Chain;

import com.middle.htmlparser.PrivateSpy.PrivateSpy;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class GetEmployees implements Chain{
    private Chain nextInChain;
    @Override
    public void setNextChain(Chain chain) {
        nextInChain = chain;
    }

    @Override
    public void search(PrivateSpy spy) throws IOException, JSONException {
        try {
            String API_KEY = "5610ffe7442d63a7679402fb8245f1ad0dfb481f0eb89ce127ef1c9bc3be3d75";
            String url_query = "SELECT NAME FROM COMPANY WHERE WEBSITE='" + spy.getDomain().getUrl() + "'";
            String query = URLEncoder.encode(url_query, StandardCharsets.UTF_8);
            URL url = new URL("https://api.peopledatalabs.com/v5/company/search?sql=" + query);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-Api-Key", API_KEY);
            connection.connect();
            String text = new Scanner(connection.getInputStream()).useDelimiter("\\Z").next();
            JSONObject jsonObject = new JSONObject(text);
            int employees = jsonObject.getJSONArray("data").getJSONObject(0).getInt("employee_count");
            spy.setEmployees(String.valueOf(employees));
        }
        catch (Exception ex) {
            spy.setEmployees("");
        }finally {
            nextInChain.search(spy);
        }
    }
}
