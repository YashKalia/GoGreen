package client;

import entity.Feature;
import entity.RequestUserFeature;
import entity.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Client {

    public static final Feature vegetarianmeal = new Feature("Eating a vegan meal");

    private static User user;
    ArrayList<String> friends = new ArrayList<String>();

    public static User getUser() {
        return user;
    }

    public static void setUser(User user1) {
        user = user1;
    }

    //calin's link-  http://wlan-145-94-214-196.wlan.tudelft.nl:8080/users/getall
    //db link-   http://localhost:8080

    /**
     * Sends a login request to the server with the username and the password
     * stored in the local variable.
     *
     * @param user the user to be logged in.
     * @return the response from the server in string format.
     * @throws IOException oof
     */
    public static String sendLoginRequest(User user) throws IOException, JSONException {
        String url = "http://http://localhost:8080/users/authenticate";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");

        JSONObject us = new JSONObject();
        us.put("password", user.getPassword());
        us.put("username", user.getUsername());

        return getOutput(con, us);
    }

    /**
     * Adds sends a post request to the server adding a new entry.
     *
     * @param feature the feature to be added (i.e. Eating a vegan meal)
     * @param user    the username who ate the meal
     * @return a string version of the server response
     * @throws IOException oof
     */
    public static boolean addEntry(Feature feature,User user,RestTemplate restTemplate) {
        String url = "http://http://localhost:8080/entries/add";
        RequestUserFeature obj2 = new RequestUserFeature(feature, user);
        Boolean response = restTemplate.postForObject(url, obj2, boolean.class);
        return response;
    }


    @SuppressWarnings("unchecked")
    public static ArrayList<Feature> getAllFeatures(RestTemplate restTemplate) {
        return (ArrayList<Feature>) restTemplate.getForObject("http://localhost:8080/features/getall", ArrayList.class);
    }

    /**
     * Gets the number of vegan / vegetarian meals the user has had.
     *
     * @param user the user whose meals to get
     * @return the number of meals
     * @throws IOException BIG OOFF
     */
    public static int getVeganMealCount(User user) throws IOException, JSONException {
        String url = "http://http://localhost:8080/entries/getvegetarianmeals";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestMethod("POST");
        JSONObject us = new JSONObject();
        us.put("username", user.getUsername());
        return Integer.parseInt(getOutput(con, us));
    }


    //User Controller Client Methods

    //AddUser

    /**
     * Takes a new user and adds it to the database.
     *
     * @param user object og type User.
     * @return String
     */
    public static String addnewuser(User user) throws IOException {
        String url = "http://http://localhost:8080/users/register";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("POST");

        con.setRequestProperty("Content-Type", "application/json");

        JSONObject newuser = new JSONObject();
        newuser.put("username", user.getUsername());
        newuser.put("password", user.getPassword());
        return getOutput(con, newuser);
    }
    //Entry Controller client side methods
    //all entry info


    /**
     * Gets all the entries of a particular username from the database.
     *
     * @param user of type User
     * @return String
     * @throws IOException in case getOutput method returns wrong result.
     */
    public static String get_entries_per_username(User user) throws IOException {
        String url = "http://http://localhost:8080/entries/getbyuser";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");

        JSONObject details = new JSONObject();
        details.put("username", user.getUsername());
        return getOutput(con, details);
    }


    //Friend Controller methods

    /**Adds the friend supplied as parameter as a friend of the user in the database.
     *
     * @param friend User object representing a friend
     * @return a response from GetOutput method
     * @throws IOException Uh-oh
     */
    public static String addaFriend(User friend) throws IOException {
        String url = "http://http://localhost:8080/friends/add";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        JSONObject send = new JSONObject();
        send.put("user", user);
        send.put("friend", friend);
        return getOutput(con, send);
    }

    /**Returns a set containing a list of yor friends.
     *
     * @param restTemplate a restTemplate object for communication.
     * @return a Set of String which contains yor list of friends
     * @throws IOException Uh-oh
     */
    @SuppressWarnings("unchecked")
    public static Set<String> getMyFriends(RestTemplate restTemplate) throws IOException {
        String uri = "http://http://localhost:8080/friends/getmyfriends/{username}";
        Map<String, String> params = new HashMap<String, String>();
        params.put("username", user.getUsername());
        return (Set<String>) restTemplate.getForObject(uri, Set.class, params);
    }

    /**Returns a list of the people who befriended you.
     *
     * @return a String
     * @throws IOException Uh-oh
     */
    public static String getPeopleWhoBefriendedMe() throws IOException {
        String url = "http://http://localhost:8080/friends/getpeoplewhobefriendedme/" + user.getUsername();
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        return getOutputwithoutobject(con);
    }

    /**gets your friends who are friends with you as well.
     *
     * @return String
     * @throws IOException Uh-oh
     */
    public static String mymutualFriends() throws IOException {
        String url = "http://http://localhost:8080/friends/getmutualfriends/" + user.getUsername();
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        return getOutputwithoutobject(con);
    }

    /**Return a list of requests which were sent to you.
     *
     * @return a String containing the requests
     * @throws IOException Uh-oh
     */
    public static String pendingrequests() throws IOException {
        String url = "http://http://localhost:8080/friends/getpendingfriendrequests/" + user.getUsername();
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        return getOutputwithoutobject(con);

    }

    /**returns a list of request that you sent to people but are still unconfirmed.
     *
     * @return a String containing the list.
     * @throws IOException Uh-oh
     */
    public static String sentpendingrequests() throws IOException {
        String url = "http://http://localhost:8080/friends/getsentpendingfriendsrequests/" + user.getUsername();
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        return getOutputwithoutobject(con);

    }

    /**Get all the badges you have earned from the database.
     *
     * @return a String containing the badges
     * @throws IOException Uh-oh
     */
    public static String iwantmybadges() throws IOException {
        String url = "http://http://localhost:8080/badgesearned/getmybadges/" + user.getUsername();
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        return getOutputwithoutobject(con);

    }
    //OUTPUT METHODS

    /**
     * Gets the string output of the server response given a connection and a json object
     * For post and put requests.
     *
     * @param con  the connection from which to get the response
     * @param send the json object to send
     * @return the string output of the server
     * @throws IOException VERY BIG OOFF
     */
    public static String getOutput(HttpURLConnection con, JSONObject send) throws IOException {
        //writing to the server
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(send.toString());
        wr.flush();
        wr.close();

        //reading from the server
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        return response.toString();
    }

    /**
     * Methods used when client sends request without object.
     *
     * @param con of type HTTPURLConnection
     * @return String
     * @throws IOException in case getOutput method returns wrong result.
     */
    public static String getOutputwithoutobject(HttpURLConnection con) throws IOException {
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.flush();
        wr.close();
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