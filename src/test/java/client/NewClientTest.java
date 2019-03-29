//package client;
//
//import entity.Feature;
//import entity.RequestUserFeature;
//import entity.User;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//import static org.mockito.Mockito.*;
//import org.junit.runner.RunWith;
//import org.springframework.web.client.RestTemplate;
//import static org.junit.Assert.assertEquals;
//
//import java.util.ArrayList;
//
//@RunWith(MockitoJUnitRunner.class)
//public class NewClientTest {
//
//    @Mock
//    RestTemplate restTemplate;
//
//    @Mock
//    Client client;
//
//    User user2;
//    User user3;
//    Feature feature;
//    RequestUserFeature ruf;
//
//    @Before
//    public void setup() {
//    	user2=new User("Andrei","password");
//    	user3=new User("Buddy","Guy");
//    	feature=new Feature("Eating a vegan meal");
//    	ruf=new RequestUserFeature(feature,user2);
//    }
//
//
//    @Test
//    public void getUserTest() {
//    	Client.setUser(user2);
//    	assertEquals(Client.getUser(),user2);
//
//    }
//
//    @Test
//    public void setUserTest() {
//    	Client.setUser(user3);
//    	assertEquals(Client.getUser(),user3);
//    }
//
//    @Test
//    public void getAllFeaturesTest() {
//    	String url="http://localhost:8080/features/getall";
//
//        when(restTemplate.getForObject(url, ArrayList.class)).thenReturn(null);
//
//        assertEquals(null, Client.getAllFeatures(restTemplate));
//
//    }
//
//    @Test
//    public void addEntryTest() {
//    	String url = "http://localhost:8080/entries/add/";
//
//    	when(restTemplate.postForObject(url,ruf,boolean.class)).thenReturn(true);
//
//    	assertEquals(true, Client.addEntry(feature,restTemplate));
//    }
//
//    @Test
//    public void testGetVeganMealCount() throws Exception {
//
//        String url = "http://localhost:8080/entries/getvegetarianmeals/user2";
//
//        when(restTemplate.getForObject(url,Integer.class)).thenReturn(2);
//
//        assertEquals(2,Client.getVegetarianMealCount(user2,restTemplate));
//
//    }
//
//
//
//    @Test
//    public void addnewuserTest() {
//    	String url="http://http://localhost:8080/users/register";
//
//    	when(restTemplate.getForObject(url, boolean.class)).thenReturn(null);
//    }
//
//}
//
//
