package client;

import Entity.Entry;
import Entity.Feature;
import Entity.User;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println(sendLoginRequest(new User("Andrei", "andreiu")));
    }

    public static String sendLoginRequest(User user) throws Exception {
        String url = "http://localhost:8080/users/authenticate";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        JSONObject us = new JSONObject();
        us.put("password",user.getPassword());
        us.put("username",user.getUsername());

        return getOutput(con,us);
    }

    public static String addEntry(Feature feature, User user) throws Exception{
        String url = "http://localhost:8080/entries/add";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        Entry entry = new Entry(feature.getFeature(), user.getUsername());

        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        JSONObject send = new JSONObject();
        send.put("feature",feature.getFeature());
        send.put("username",user.getUsername());

        return getOutput(con,send);
    }

    public static String getOutput(HttpURLConnection con, JSONObject send) throws IOException {
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(send.toString());
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        return response.toString();
    }
}
