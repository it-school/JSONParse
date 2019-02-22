package com.itschool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {

    public static void main(String[] args) {
        String jsonIn = "{\"cod\":\"200\",\"message\":0,\"city\":{\"geoname_id\":1907296,\"name\":\"Tawarano\",\"lat\":35.0164,\"lon\":139.0077,\"country\":\"JP\",\"iso2\":\"JP\",\"type\":\"\",\"population\":0},\"cnt\":10,\"list\":[{\"dt\":1485741600,\"temp\":{\"day\":285.51,\"min\":285.51,\"max\":285.51,\"night\":285.51,\"eve\":285.51,\"morn\":285.51},\"pressure\":1013.75,\"humidity\":100,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01n\"}],\"speed\":5.52,\"deg\":311,\"clouds\":0},{\"dt\":1485828000,\"temp\":{\"day\":282.27,\"min\":282.27,\"max\":284.66,\"night\":284.66,\"eve\":282.78,\"morn\":282.56},\"pressure\":1023.68,\"humidity\":100,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}],\"speed\":5.46,\"deg\":66,\"clouds\":0},{\"dt\":1485914400,\"temp\":{\"day\":284.83,\"min\":283.21,\"max\":285.7,\"night\":284.16,\"eve\":285.49,\"morn\":283.21},\"pressure\":1017.39,\"humidity\":100,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"02d\"}],\"speed\":13.76,\"deg\":260,\"clouds\":8},{\"dt\":1486000800,\"temp\":{\"day\":283.71,\"min\":281.86,\"max\":285.13,\"night\":283.81,\"eve\":284.76,\"morn\":281.86},\"pressure\":1017.36,\"humidity\":100,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}],\"speed\":8.95,\"deg\":288,\"clouds\":0},{\"dt\":1486087200,\"temp\":{\"day\":280,\"min\":275.68,\"max\":283.75,\"night\":278.79,\"eve\":283.75,\"morn\":275.68},\"pressure\":996.2,\"humidity\":0,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":5.92,\"deg\":295,\"clouds\":0},{\"dt\":1486173600,\"temp\":{\"day\":279.4,\"min\":276.69,\"max\":283.22,\"night\":277.58,\"eve\":283.22,\"morn\":276.69},\"pressure\":998.07,\"humidity\":0,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}],\"speed\":3.71,\"deg\":314,\"clouds\":0},{\"dt\":1486260000,\"temp\":{\"day\":280.88,\"min\":276.28,\"max\":284.66,\"night\":281.2,\"eve\":284.66,\"morn\":276.28},\"pressure\":997.4,\"humidity\":0,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":2.1,\"deg\":337,\"clouds\":66,\"rain\":0.28},{\"dt\":1486346400,\"temp\":{\"day\":281.58,\"min\":278.74,\"max\":283.76,\"night\":278.74,\"eve\":283.76,\"morn\":279.15},\"pressure\":991.11,\"humidity\":0,\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10d\"}],\"speed\":2.69,\"deg\":2,\"clouds\":4,\"rain\":3.72},{\"dt\":1486432800,\"temp\":{\"day\":277.62,\"min\":275.86,\"max\":281.14,\"night\":276.45,\"eve\":281.14,\"morn\":275.86},\"pressure\":993.37,\"humidity\":0,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}],\"speed\":2.05,\"deg\":353,\"clouds\":47,\"rain\":0.52,\"snow\":0.03},{\"dt\":1486519200,\"temp\":{\"day\":279.26,\"min\":275.51,\"max\":281.61,\"night\":276.55,\"eve\":281.61,\"morn\":275.51},\"pressure\":991.72,\"humidity\":0,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"speed\":3.47,\"deg\":326,\"clouds\":2,\"rain\":0.35}]}";
        boolean cont = false;
        JSONObject json = null;
        try {
            json = new JSONObject(jsonIn);
            cont = true;
        } catch (JSONException e) {
            System.out.println("Error parsing data " + e.toString());
        }

            try {
                String temp1 = "";
                JSONArray jsonMain = (JSONArray) json.get("list");
                System.out.println(jsonMain);

                for (Object forecast: jsonMain)
                {
                    JSONObject jsonForecast = (JSONObject)forecast;
                    SimpleDateFormat sm = new SimpleDateFormat("d.M.Y H:m");  // https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
                    sm.setTimeZone(TimeZone.getTimeZone("GMT+2"));
                    Date date = new Date(jsonForecast.getLong("dt") * 1000);
                    System.out.println(date.toGMTString());

                    int humidity = jsonForecast.getInt("humidity");
                    float pressure = jsonForecast.getFloat ("pressure");
                    System.out.println(humidity);
                    System.out.println(pressure);

                    JSONArray weather = jsonForecast.getJSONArray("weather");
                    String main = (weather.getJSONObject(0)).getString("main");
                    //String main = ((JSONObject)(weather.get(0))).getString("main");
                    System.out.println(main);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
   }
}
