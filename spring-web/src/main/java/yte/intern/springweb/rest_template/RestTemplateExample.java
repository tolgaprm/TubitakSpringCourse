package yte.intern.springweb.rest_template;

import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import yte.intern.springweb.uygulama1.User;

import java.net.URI;

@Component
public class RestTemplateExample {
    public void sendRestRequest() {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = UriComponentsBuilder.fromHttpUrl("http://www.google.com/maps")
                .pathSegment("1")
                .queryParam("lon", 45.458)
                .queryParam("lat", 48.5845)
                .build()
                .toUri();
        RequestEntity<Void> requestEntity = RequestEntity.get(uri).header("key", "value").build();
        ResponseEntity<String> exchange = restTemplate.exchange(requestEntity, String.class);
        System.out.println(exchange);
    }

    public void sendBodyRequest() {
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<User> requestEntity = RequestEntity.post(URI.create("http://www.google.com/maps"))
                .header("key", "value")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new User());

        ResponseEntity<String> exchange = restTemplate.exchange(requestEntity, String.class);
        System.out.println(exchange);
    }
}