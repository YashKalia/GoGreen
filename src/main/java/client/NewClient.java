package client;

import entity.Feature;
import entity.User;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewClient {

    public static void main(String[] args) {
        if(!isInitiated) {
            initiate();
        }

        System.out.println(createAccount( restTemplate));

    }

    private static RestTemplate restTemplate = new RestTemplate();
    private static boolean isInitiated = false;

    public static void initiate() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        //Add the Jackson Message converter
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        // Note: here we are making this converter to process any kind of response,
        // not only application/*json, which is the default behaviour
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);
        isInitiated = true;
    }

    public static List<Feature> getAllFeatures(RestTemplate restTemplate) {
        return restTemplate.getForObject("http://localhost:8080/features/getall", List.class);
    }

    public static boolean createAccount(RestTemplate restTemplate) {
        User user = new User();
        user.setPassword("parola");
        user.setUsername("user13");
        return restTemplate.postForObject("http://localhost:8080/users/register",user,Boolean.class);
    }

}
