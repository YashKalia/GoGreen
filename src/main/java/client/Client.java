package client;

import entity.Entry;
import entity.Feature;
import entity.User;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client {

    public static final Feature vegetarianmeal = new Feature("Eating a vegan meal");

    private static User user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user1) {
        user = user1;
    }

    /**
     * Sends a login request to the server with the username and the password
     * stored in the local variable.
     * @param user the user to be logged in.
     * @return the response from the server in string format.
     * @throws IOException oof
     */
    public static String sendLoginRequest(User user) throws IOException, JSONException {
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

    /**
     * Adds sends a post request to the server adding a new entry.
     * @param feature the feature to be added (i.e. Eating a vegan meal)
     * @param user the username who ate the meal
     * @return a string bersion of the server response
     * @throws IOException oof
     */
    public static String addEntry(Feature feature, User user) throws IOException, JSONException {
        String url = "http://localhost:8080/entries/add";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        Entry entry = new Entry(feature.getFeature(), user.getUsername());

        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");

        JSONObject send = new JSONObject();
        JSONObject ft = new JSONObject();
        JSONObject us = new JSONObject();
        ft.put("featureName",feature.getFeature());
        us.put("username",user.getUsername());
        send.put("feature",ft);
        send.put("user",us);

        return getOutput(con,send);
    }

    /**
     * Gets the number of vegan / vegetarian meals the user has had.
     * @param user the user whose meals to get
     * @return the number of meals
     * @throws IOException BIG OOFF
     */
    public static int getVeganMealCount(User user) throws IOException, JSONException {
        String url = "http://localhost:8080/entries/getvegetarianmeals";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestProperty("Content-Type","application/json");
        con.setRequestMethod("POST");
        JSONObject us = new JSONObject();
        us.put("username",user.getUsername());
        return Integer.parseInt(getOutput(con,us));
    }

    /**
     * Gets the string output of the server response given a connection and a json object
     * For post and put requests.
     * @param con the connection from which to get the response
     * @param send the json object to send
     * @return the string output of the server
     * @throws IOException VERY BIG OOFF
     */
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
