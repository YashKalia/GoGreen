package client;

import entity.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Client {

    public static final Feature vegetarianmeal = new Feature("Eating a vegan meal");
    private static RestTemplate restTemplate = new RestTemplate();
    private static boolean isInitiated = false;
    private static User user;
    ArrayList<String> friends = new ArrayList<String>();

    public static User getUser() {
        return user;
    }


    public static void setUser(User user1) {
        user = user1;
    }

    /**Sends a login request with username,password.
     *
     * @param restTemplate restTemplate object for connection
     * @return string response
     * @throws IOException oof
     */
    public static boolean sendLoginRequest(RestTemplate restTemplate) throws IOException {
        String url = "http://localhost:8080/users/authenticate";
        Boolean response = (Boolean)restTemplate.postForObject(url,Client.getUser().getUsername(),Boolean.class);
        return response;
    }

    /**
     * Initiate a connection
     */
    public static void initiate() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        //Add the Jackson Message converter
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        // Note: here we are making this converter to process any kind of response,
        // not only application/*json, which is the default behaviour
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
        messageConverters.add(converter);
        Client.restTemplate.setMessageConverters(messageConverters);
        Client.isInitiated = true;
    }

    /**
     * Adds sends a post request to the server adding a new entry.
     *
     * @param feature the feature to be added (i.e. Eating a vegan meal)
     * @param user    the username who ate the meal
     * @return a string version of the server response
     * @throws IOException oof
     */
    public static boolean addEntry(Feature feature,RestTemplate restTemplate) {
        String url = "http://localhost:8080/entries/add";
        RequestUserFeature obj2 = new RequestUserFeature(feature, Client.getUser());
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
 
    public static int getVeganMealCount(User user, RestTemplate restTemplate) {
        String url = "http://localhost:8080/entries/getvegetarianmeals/";
        url+= user.getUsername();
        return (int)restTemplate.getForObject(url,Integer.class);

    }


    //User Controller Client Methods

    //AddUser

    /**
     * Takes a new user and adds it to the database.
     *
     * @param user object og type User.
     * @return boolean
     */
    public static boolean addnewuser(User user, RestTemplate restTemplate) throws IOException {
        String url = "http://localhost:8080/users/register";
        boolean response = restTemplate.postForObject(url, user, boolean.class);
        return response;


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

    @SuppressWarnings("unchecked")
    public static List<Entry> get_entries_per_username(User user, RestTemplate restTemplate){
        String url = "http://localhost:8080/entries/getbyuser";

        return (List<Entry>) restTemplate.postForObject(url, user, List.class);

    }


    //Friend Controller methods

    /**
     * Adds the friend supplied as parameter as a friend of the user in the database.
     *
     * @param friend User object representing a friend
     * @return a response from GetOutput method
     * @throws IOException Uh-oh
     */
    public static boolean addaFriend(User friend, RestTemplate restTemplate) throws IOException {
        String url = "http://localhost:8080/friends/add";
        boolean response = (Boolean) restTemplate.postForObject(url, friend, Boolean.class);
        return response;

    }

    /**
     * Returns a set containing a list of yor friends.
     *
     * @param restTemplate a restTemplate object for communication.
     * @return a Set of String which contains yor list of friends
     * @throws IOException Uh-oh
     */
    public static Set<String> getMyFriends(RestTemplate restTemplate) throws IOException {
        String uri = "http://localhost:8080/friends/getmyfriends/" + Client.getUser().getUsername();
        @SuppressWarnings("unchecked")
        Set<String> response = (Set<String>) restTemplate.getForObject(uri, Set.class);
        return response;

    }

    /**
     * Returns a list of the people who befriended you.
     *
     * @return a String
     * @throws IOException Uh-oh
     */
    public static Set<String> getPeopleWhoBefriendedMe(RestTemplate restTemplate) {
        String url = "http://localhost:8080/friends/getpeoplewhobefriendedme/" + Client.getUser().getUsername();
        @SuppressWarnings("unchecked")
        Set<String> response = (Set<String>) restTemplate.getForObject(url, Set.class);
        return response;

    }

    /**
     * gets your friends who are friends with you as well.
     *
     * @return String
     * @throws IOException Uh-oh
     */
    public static Set<String> mymutualFriends(RestTemplate restTemplate) throws IOException {
        String url = "http://localhost:8080/friends/getmutualfriends/" + Client.getUser().getUsername();
        @SuppressWarnings("unchecked")
        Set<String> response = (Set<String>) restTemplate.getForObject(url, Set.class);
        return response;
    }

    /**
     * Return a list of requests which were sent to you.
     *
     * @return a String containing the requests
     * @throws IOException Uh-oh
     */
    public static Set<String> pendingrequests(RestTemplate restTemplate) throws IOException {
        String url = "http://localhost:8080/friends/getpendingfriendrequests/" + Client.getUser().getUsername();
        @SuppressWarnings("unchecked")
        Set<String> response = (Set<String>) restTemplate.getForObject(url, Set.class);
        return response;


    }

    /**
     * returns a list of request that you sent to people but are still unconfirmed.
     *
     * @return a String containing the list.
     * @throws IOException Uh-oh
     */
    public static Set<String> sentpendingrequests(RestTemplate restTemplate) throws IOException {
        String url = "http://localhost:8080/friends/getsentpendingfriendsrequests/" + Client.getUser().getUsername();
        @SuppressWarnings("unchecked")
        Set<String> response = (Set<String>) restTemplate.getForObject(url, Set.class);
        return response;


    }

    /**
     * Get all the badges you have earned from the database.
     *
     * @return a String containing the badges
     * @throws IOException Uh-oh
     */
    @SuppressWarnings("unchecked")
    public static List<BadgesEarned> iwantmybadges(RestTemplate restTemplate) throws IOException {
        String url="http://localhost:8080/badgesearned/getmybadges/" + Client.getUser().getUsername();
        List<BadgesEarned> response =(List<BadgesEarned>) restTemplate.getForObject(url, List.class);
        return response;


    }
    //OUTPUT METHODS
/*

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

    *//**

     *//*
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
    }*/
}