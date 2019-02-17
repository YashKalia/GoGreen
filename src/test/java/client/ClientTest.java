package client;

import entity.Feature;
import entity.Friends;
import entity.RequestUserFeature;
import entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientTest {

    @Mock
    RestTemplate restTemplate;

    private User user5;
    private User user2;
    private Feature vegetarianMeal;
    private static final String localUrl = "http://localhost:8080/";

    @Before
    public void setup() {
        user5 = new User("user5","password");
        user2 = new User("user2",null);
        vegetarianMeal = new Feature("Eating a vegetarian meal");
        Client.setUser(user5);
    }

//    @Test
//    public void testGetRestTemplate() {
//
//        when(Client.getRestTemplate()).thenReturn(this.restTemplate);
//
//        assertEquals(restTemplate, Client.getRestTemplate());
//    }

//    @Test
//    public void testGetUrl() {
//        assertEquals(localUrl,Client.getUrl());
//    }

    @Test
    public void testGetUser() {

        assertEquals(user5, Client.getUser());

    }

    @Test
    public void setUser() {

        Client.setUser(user2);

        assertEquals(user2, Client.getUser());

    }

    @Test
    public void testSendLoginRequestTest() {

        when(restTemplate.postForObject(localUrl+"/users/authenticate",user5,Boolean.class)).thenReturn(true);

        assertEquals(true,Client.sendLoginRequest(localUrl,user5,restTemplate));
    }

    @Test
    public void addEntryTest() {

        RequestUserFeature re = new RequestUserFeature(vegetarianMeal,user5);

        when(restTemplate.postForObject(localUrl+"/entries/add",re,Boolean.class)).thenReturn(true);

        assertEquals(true, Client.addEntry(localUrl,user5,vegetarianMeal,restTemplate));
    }

    @Test
    public void getVegetarianMealsTest() {

        when(restTemplate.getForObject(localUrl+"/entries/getvegetarianmeals/user5",Integer.class))
                .thenReturn(42);

        assertEquals(42,Client.getVegetarianMeals(localUrl,user5,restTemplate));
    }

    @Test
    public void registerTest() {
        when(restTemplate.postForObject(localUrl+"/users/register",user5,Boolean.class))
                .thenReturn(false);

        assertEquals(false,Client.register(localUrl,user5,restTemplate));
    }

    @Test
    public void addFriendTest() {
        Friends fr = new Friends(user5,user2);

        when(restTemplate.postForObject(localUrl+"/friends/add",fr,Boolean.class))
                .thenReturn(true);

        assertEquals(true, Client.addFriend(localUrl,fr,restTemplate));
    }

    @Test
    public void getMutualFriendsTest() {

        HashSet<String> mutualFriends = new HashSet();

        mutualFriends.add(user2.getUsername());

        when(restTemplate.getForObject(localUrl+"/friends/getmutualfriends/user5", Set.class))
                .thenReturn(mutualFriends);

        assertEquals(mutualFriends,Client.getMutualFriends(localUrl,user5,restTemplate));
    }

    @Test
    public void getPendingRequestsTest() {

        HashSet<String> friends= new HashSet();

        friends.add(user2.getUsername());

        when(restTemplate.getForObject(localUrl+"/friends/getpendingfriendrequests/user5", Set.class))
                .thenReturn(friends);

        assertEquals(friends,Client.getPendingRequests(localUrl,user5,restTemplate));
    }

    @Test
    public void getSentPendingRequestsTest() {

        HashSet<String> friends= new HashSet();

        friends.add(user2.getUsername());

        when(restTemplate.getForObject(localUrl+"/friends/getsentpendingfriendsrequests/user5", Set.class))
                .thenReturn(friends);

        assertEquals(friends,Client.getSentPendingRequests(localUrl,user5,restTemplate));
    }

    @Test
    public void getMyBadgesTest() {
        HashSet<String> badges = new HashSet<>();

        badges.add("You can literally put whatever you want in here");

        when(restTemplate.getForObject(localUrl+"/badgesearned/getmybadges/"+user5.getUsername(),Set.class))
                .thenReturn(badges);

        assertEquals(badges,Client.getMyBadges(localUrl,user5,restTemplate));
    }

    @Test
    public void getAllBadgesTest() {
        HashSet<String> badges = new HashSet<>();
        badges.add("You can literally put whatever you want in here");

        when(restTemplate.getForObject(localUrl+"/badges/getallbadges/"+user5.getUsername(),Set.class))
                .thenReturn(badges);

        assertEquals(badges,Client.getMyBadges(localUrl,user5,restTemplate));
    }

    @Test
    public void getLocalProduceTest() {

        when(restTemplate.getForObject(localUrl+"/entries/getlocalproduce/user5",Integer.class))
                .thenReturn(42);

        assertEquals(42,Client.getLocalProduce(localUrl,user5,restTemplate));
    }

    @Test
    public void getLoweringTemperatureTest() {

        when(restTemplate.getForObject(localUrl+"/entries/getloweringtemperature/user5",Integer.class))
                .thenReturn(42);

        assertEquals(42,Client.getLoweringTemperature(localUrl,user5,restTemplate));
    }

    @Test
    public void getSolarPanelsTest() {

        when(restTemplate.getForObject(localUrl+"/entries/getsolarpanels/user5",Integer.class))
                .thenReturn(42);

        assertEquals(42,Client.getSolarPanels(localUrl,user5,restTemplate));
    }

    @Test
    public void getPublicTransport() {

        when(restTemplate.getForObject(localUrl+"/entries/getpublictransport/user5",Integer.class))
                .thenReturn(42);

        assertEquals(42,Client.getPublicTransport(localUrl,user5,restTemplate));
    }

    @Test
    public void getBikeRidesTest() {

        when(restTemplate.getForObject(localUrl+"/entries/getbikerides/user5",Integer.class))
                .thenReturn(42);

        assertEquals(42,Client.getBikeRides(localUrl,user5,restTemplate));
    }

    @Test
    public void getTotalCo2Test() {
        when(restTemplate.getForObject(localUrl+"/entries/gettotalco2/"+user5.getUsername(),Double.class))
                .thenReturn(42.42);

        assertEquals(42.42,Client.getTotalCo2(localUrl,user5,restTemplate),0);
    }

    @Test
    public void getWeekCo2Test() {
        when(restTemplate.getForObject(localUrl+"/entries/getweekco2/"+user5.getUsername()+"/7",Double.class))
                .thenReturn(42.42);

        assertEquals(42.42,Client.getWeekCo2(localUrl,user5,restTemplate,7),0);
    }

    @Test
    public void getMonthCo2Test() {
        when(restTemplate.getForObject(localUrl+"/entries/getmonthco2/"+user5.getUsername()+"/07",Double.class))
                .thenReturn(42.42);

        assertEquals(42.42,Client.getMonthCo2(localUrl,user5,restTemplate,"07"),0);
    }
}