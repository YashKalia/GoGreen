package client;

import entity.Feature;
import entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ClientTest {

    @Mock
    private Client client;

    private User user5;
    private User user2;
    private Feature vegetarianMeal;

    @Before
    public void setup2() {

        user5 = new User("user5", "password");
        user2 = new User("user2", "password");

        vegetarianMeal = new Feature("Eating a vegan meal");

        client = new Client();
        client.setUser(user5);

    }

    @Test
    public void testGetUser() {

        assertEquals(user5, client.getUser());

    }

    @Test
    public void setUser() {

        client.setUser(user2);

        assertEquals(user2, client.getUser());

    }

    @Test
    public void testSendLoginRequest() {


    }


//    @Test
//    public void testGetOutput() throws IOException {
//
//        String url = "http://localhost:8080/entries/getvegetarianmeals";
//        URL obj = new URL(url);
//        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//        con.setRequestMethod("POST");
//        con.setRequestProperty("Content-Type","application/json");
//        JSONObject us = new JSONObject();
//        us.put("username",user5.getUsername());
//
//        int response = Integer.parseInt(getOutput(con,us));
//
//        assertTrue(response > 2);
//
//    }
}