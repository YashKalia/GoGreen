package client;

import entity.Feature;
import entity.Friends;
import entity.RequestUserFeature;
import entity.User;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Client {

    private static RestTemplate restTemplate = new RestTemplate();
    private static boolean isInitiated = false;
    private static User user = new User();
    private static final String herokuUrl = "https://projectgogreen.herokuapp.com/";
    private static final String localUrl = "http://localhost:8080/";

    public static void enableBasicAuthentication() {
        if (!Client.isInitiated) {
            Client.restTemplate = new RestTemplateBuilder()
                    .basicAuthentication(Client.getUser().getUsername(),
                            Client.getUser().getPassword()).build();
            Client.isInitiated=true;
        }
    }

    public static User getUser() {
        return user;
    }


    public static void setUser(User user1) {
        user = user1;
    }

    public static RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public static String getUrl() {
        return herokuUrl;
    }

    /**
     * Sends a login request with username,password.
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * This is only in case of backup. Use BA otherwise.
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     *
     * @param restTemplate restTemplate object for connection
     * @return string response
     * @throws IOException oof
     */
    public static boolean sendLoginRequest(String url, User user, RestTemplate restTemplate) {
        url += "/users/authenticate";
        return restTemplate.postForObject(url, user, Boolean.class);
    }

    /**
     * Adds an entry to the database.
     *
     * @param url          base url (localhost/heroku)
     * @param user         the user who adds the entry
     * @param feature      the feature which they add
     * @param restTemplate .
     * @return true if adding worked.
     */
    public static String addEntry(String url, User user,
                                   Feature feature, RestTemplate restTemplate) {
        url += "/entries/add";
        RequestUserFeature obj2 = new RequestUserFeature(feature, user);
        return restTemplate.postForObject(url, obj2, String.class);
    }

    /**
     * Takes a new user and adds it to the database.
     *
     * @param user object og type User.
     * @return boolean
     */
    public static String register(String url, User user,
                                   RestTemplate restTemplate) throws HttpServerErrorException {
        url += "/users/register";
        return restTemplate.postForObject(url, user, String.class);
    }

    /**
     * Adds the friend supplied as parameter as a friend of the user in the database.
     *
     * @param friends User object representing a friend
     * @return a response from GetOutput method
     * @throws IOException Uh-oh
     */
    public static String addFriend(String url, Friends friends,
                                    RestTemplate restTemplate) throws HttpServerErrorException {
        url += "/friends/add";
        return restTemplate.postForObject(url, friends, String.class);
    }

    /**
     * gets your friends who are friends with you as well.
     *
     * @return String
     */
    public static HashSet<String> getMutualFriends(String url,
                                                   User user, RestTemplate restTemplate) {
        url += "/friends/getmutualfriends/" + user.getUsername();
        return (HashSet<String>) restTemplate.getForObject(url, Set.class);
    }

    /**
     * Return a list of requests which were sent to you.
     *
     * @return a String containing the requests
     */
    public static HashSet<String> getPendingRequests(String url,
                                                     User user, RestTemplate restTemplate) {
        url += "/friends/getpendingfriendrequests/" + user.getUsername();
        return (HashSet<String>) restTemplate.getForObject(url, Set.class);
    }

    /**
     * returns a list of request that you sent to people but are still unconfirmed.
     *
     * @return a String containing the list.
     */
    public static HashSet<String> getSentPendingRequests(String url,
                                                         User user, RestTemplate restTemplate) {
        url += "/friends/getsentpendingfriendsrequests/" + user.getUsername();
        return (HashSet<String>) restTemplate.getForObject(url, Set.class);
    }

    /**
     * Get all the badges you have earned from the database.
     *
     * @return a String containing the badges
     * @throws IOException Uh-oh
     */
    public static HashSet<String> getMyBadges(String url,
                                              User user, RestTemplate restTemplate) {
        url += "/badgesearned/getmybadges/" + user.getUsername();
        return (HashSet<String>) restTemplate.getForObject(url, Set.class);
    }

    /**
     * Gets the total number of vegetarian meals for one user.
     *
     * @param url          the url to send the request to (heroku/localhost)
     * @param user         the user.
     * @param restTemplate the initiated template including BA
     * @return the number of features consumed
     */
    public static int getVegetarianMeals(String url, User user, RestTemplate restTemplate) {
        url += "/entries/getvegetarianmeals/";
        url += user.getUsername();
        return restTemplate.getForObject(url, Integer.class);
    }

    /**
     * Gets the total number of times a user has bought local produce.
     *
     * @param url          the url to send the request to (heroku/localhost)
     * @param user         the user.
     * @param restTemplate the initiated template including BA
     * @return the number of features consumed
     */
    public static int getLocalProduce(String url, User user, RestTemplate restTemplate) {
        url += "/entries/getlocalproduce/";
        url += user.getUsername();
        return restTemplate.getForObject(url, Integer.class);
    }

    /**
     * Gets the total number of times a user has used a bike instead of a car.
     *
     * @param url          the url to send the request to (heroku/localhost)
     * @param user         the user.
     * @param restTemplate the initiated template including BA
     * @return the number of features consumed
     */
    public static int getBikeRides(String url, User user, RestTemplate restTemplate) {
        url += "/entries/getbikerides/";
        url += user.getUsername();
        return restTemplate.getForObject(url, Integer.class);
    }

    /**
     * Gets the number of times a use has used the public transport feature.
     *
     * @param url          the url to send the request to (heroku/localhost)
     * @param user         the user.
     * @param restTemplate the initiated template including BA
     * @return the number of features consumed
     */
    public static int getPublicTransport(String url, User user, RestTemplate restTemplate) {
        url += "/entries/getpublictransport/";
        url += user.getUsername();
        return restTemplate.getForObject(url, Integer.class);
    }

    /**
     * Gets the total number of times a use has lowered the temperature of their home.
     *
     * @param url          the url to send the request to (heroku/localhost)
     * @param user         the user.
     * @param restTemplate the initiated template including BA
     * @return the number of features consumed
     */
    public static int getLoweringTemperature(String url, User user, RestTemplate restTemplate) {
        url += "/entries/getloweringtemperature/";
        url += user.getUsername();
        return restTemplate.getForObject(url, Integer.class);
    }

    /**
     * Gets the total number of solar panels for one user.
     *
     * @param url          the url to send the request to (heroku/localhost)
     * @param user         the user.
     * @param restTemplate the initiated template including BA
     * @return the number of features consumed
     */
    public static int getSolarPanels(String url, User user, RestTemplate restTemplate) {
        url += "/entries/getsolarpanels/";
        url += user.getUsername();
        return restTemplate.getForObject(url, Integer.class);
    }

    /**
     * Total amount of co2 which you saved.
     *
     * @param url          local/heroku
     * @param user         the user
     * @param restTemplate the initiated resttemplate including BA
     * @return the amount of co2 saved
     */
    public static double getTotalCo2(String url, User user, RestTemplate restTemplate) {
        url += "/entries/gettotalco2/" + user.getUsername();
        return restTemplate.getForObject(url, Double.class);
    }

    /**
     * Amount of co2 saved in a week.
     *
     * @param url          local/heroku
     * @param user         the use
     * @param restTemplate same as the rest
     * @param week         a number between 1 and 52
     * @return the amount of co2 saved by that user in that week
     */
    public static double getWeekCo2(String url, User user, RestTemplate restTemplate, int week) {
        url += "/entries/getweekco2/" + user.getUsername() + "/" + week;
        return restTemplate.getForObject(url, Double.class);
    }

    /**
     * Amount of co2 saved in a month.
     *
     * @param url          local/heroku
     * @param user         the user
     * @param restTemplate initiated with BA
     * @param month        !!!A string of 2 digits following this pattern:
     *                     January = 01
     *                     February = 02
     *                     .
     *                     .
     *                     .
     *                     October = 10
     *                     November = 11
     *                     December = 12
     * @return A double representing the amount of CO2 saved in a month
     */
    public static double getMonthCo2(String url, User user,
                                     RestTemplate restTemplate, String month) {
        url += "/entries/getmonthco2/" + user.getUsername() + "/" + month;
        return restTemplate.getForObject(url, Double.class);
    }
}