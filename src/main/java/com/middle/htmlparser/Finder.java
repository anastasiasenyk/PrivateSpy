package com.middle.htmlparser;

import org.json.simple.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Finder {

    public static JSONObject main(String[] args) throws IOException {

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
//        return jsonObject;
//        find_employee(jsonObject);
//        find_address(jsonObject);
        return null;
    }

}
