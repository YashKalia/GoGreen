package client;

import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

public class Client {

    public static void main(String[] args) {
//        User calin = new User("calin","password");
//        System.out.println(sendLoginRequest(Client.herokuUrl,Client.restTemplate,new User("calin","password")));
//        Feature meal = new Feature("Eating a vegetarian meal");
//        Client.addEntry(Client.herokuUrl, new User("calin", null),meal,Client.restTemplate);
//        System.out.println(getVegetarianMealCount(herokuUrl,calin,restTemplate));
        Client client = new Client();
        System.out.print(client.callSecurityService());
    }

    public ArrayList<Feature> callSecurityService() {
       RestTemplate restTemplate = new RestTemplate();
               restTemplateBuilder.basicAuthentication("Andrei","andreiu").build();
        Client.initiate(restTemplate);
        System.out.print(restTemplate.getForObject(localUrl+"features/secure/sth",ArrayList.class));
       return restTemplate.getForObject(localUrl+"features/secure/sth",ArrayList.class);
    }

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    private RestTemplate restTemplate = new RestTemplate();
    private static boolean isInitiated = false;
    private static User user;
    private static final String herokuUrl = "https://projectgogreen.herokuapp.com/";
    private static final String localUrl = "http://localhost:8080/";
    ArrayList<String> friends = new ArrayList<String>();

    public static User getUser() {
        return user;
    }


    public static void setUser(User user1) {
        user = user1;
    }

    /**
     * Sends a login request with username,password.
     *
     * @param restTemplate restTemplate object for connection
     * @return string response
     * @throws IOException oof
     */
    public static boolean sendLoginRequest(String url, RestTemplate restTemplate, User user) {
        url += "/users/authenticate";
        return restTemplate.postForObject(url, user, Boolean.class);
    }

    /**
     * Initiate a connection
     */
    public static void initiate(RestTemplate restTemplate) {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);
        Client.isInitiated = true;
    }


    public static boolean addEntry(String url, User user, Feature feature, RestTemplate restTemplate) {
        url += "/entries/add";
        RequestUserFeature obj2 = new RequestUserFeature(feature, user);
        return restTemplate.postForObject(url, obj2, Boolean.class);
    }


    /**
     * Gets the number of vegan / vegetarian meals the user has had.
     *
     * @param user the user whose meals to get
     * @return the number of meals
     * @throws IOException BIG OOFF
     */

    public static int getVegetarianMealCount(String url, User user, RestTemplate restTemplate) {
        url += "/entries/getvegetarianmeals/";
        url += user.getUsername();
        return restTemplate.getForObject(url, Integer.class);
    }

    /**
     * Takes a new user and adds it to the database.
     *
     * @param user object og type User.
     * @return boolean
     */
    public static boolean register(String url, User user, RestTemplate restTemplate) {
        url += "/users/register";
        return restTemplate.postForObject(url, user, Boolean.class);
    }

    /**
     * Adds the friend supplied as parameter as a friend of the user in the database.
     *
     * @param friend User object representing a friend
     * @return a response from GetOutput method
     * @throws IOException Uh-oh
     */
    public static boolean addFriend(String url, User user, User friend, RestTemplate restTemplate) {
        url += "/friends/add";
        Friends friends = new Friends(user, friend);
        return restTemplate.postForObject(url, friends, Boolean.class);
    }

    /**
     * Returns a set containing a list of yor friends.
     *
     * @param restTemplate a restTemplate object for communication.
     * @return a Set of String which contains yor list of friends
     * @throws IOException Uh-oh
     */
    public static HashSet<String> getMyFriends(String url, User user, RestTemplate restTemplate) {
        url += "/friends/getmyfriends/" + user.getUsername();
        return (HashSet<String>) restTemplate.getForObject(url, Set.class);
    }


    /**
     * gets your friends who are friends with you as well.
     *
     * @return String
     * @throws IOException Uh-oh
     */
    public static HashSet<String> getMutualFriends(String url, User user, RestTemplate restTemplate) {
        url += "/friends/getmutualfriends/" + user.getUsername();
        return (HashSet<String>) restTemplate.getForObject(url, Set.class);
    }

    /**
     * Return a list of requests which were sent to you.
     *
     * @return a String containing the requests
     * @throws IOException Uh-oh
     */
    public static HashSet<String> getPendingRequests(String url, User user, RestTemplate restTemplate) {
        url += "/friends/getpendingfriendsrequests/" + user.getUsername();
        return (HashSet<String>) restTemplate.getForObject(url, Set.class);
    }

    /**
     * returns a list of request that you sent to people but are still unconfirmed.
     *
     * @return a String containing the list.
     * @throws IOException Uh-oh
     */
    public static HashSet<String> getSentPendingRequests(String url, User user, RestTemplate restTemplate) {
        url += "friends/getsentpendingfriendsrequests/" + user.getUsername();
        return (HashSet<String>) restTemplate.getForObject(url, Set.class);
    }

    /**
     * Get all the badges you have earned from the database.
     *
     * @return a String containing the badges
     * @throws IOException Uh-oh
     */
    @SuppressWarnings("unchecked")
    public static ArrayList<BadgesEarned> getMyBadges(String url, User user, RestTemplate restTemplate) {
        url += "/badgesearned/getmybadges/" + user.getUsername();
        return (ArrayList<BadgesEarned>) restTemplate.getForObject(url, List.class);
    }
}