package com.grzsoftware.cassinobackend.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class RandomNumberGenerator {
    private final String API_URL;

    public RandomNumberGenerator(int min, int max) {
        this.API_URL = "https://www.random.org/integers/?num=1&min=" + min + "&max=" + max + "&col=1&base=10&format=plain&rnd=new/";
    }

    public int getRandomNumber() throws Exception {

        URL url = new URI(API_URL).toURL();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();
        con.disconnect();

        return Integer.parseInt(response.toString().trim());
    }
}
