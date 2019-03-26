package client;

import entity.Feature;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import org.junit.runner.RunWith;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class NewClientTest {

    @Mock
    RestTemplate restTemplate;

    @Before
    public void setup() {
    }

    @Test
    public void getAllFeaturesTest() {

        List<Feature> features;

        when(restTemplate.getForObject("http://localhost:8080/features/getall", ArrayList.class)).thenReturn(null);

        assertEquals(null, NewClient.getAllFeatures(restTemplate));

    }

}
