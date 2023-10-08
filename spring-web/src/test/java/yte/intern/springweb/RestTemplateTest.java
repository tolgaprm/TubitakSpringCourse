package yte.intern.springweb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import yte.intern.springweb.rest_template.Comment;
import yte.intern.springweb.rest_template.Post;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestTemplateTest {

    RestTemplate restTemplate;
    UriComponentsBuilder uriComponentsBuilder;

    @BeforeEach
    void setUp() {
        restTemplate = new RestTemplate();
        uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl("https://jsonplaceholder.typicode.com/");
    }

    @Test
    void getAllPosts() {
        URI uri = uriComponentsBuilder
                .pathSegment("posts")
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build();
        ResponseEntity<Post[]> response = restTemplate.exchange(requestEntity, Post[].class);
        List<Post> posts = Arrays.stream(response.getBody()).toList();
        System.out.println(posts);
    }

    @Test
    void getPostById() {
        URI uri = uriComponentsBuilder
                .pathSegment("posts", "2")
                .build().toUri();
        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build();
        ResponseEntity<Post> response = restTemplate.exchange(requestEntity, Post.class);
        System.out.println(response.getBody());
    }

    @Test
    void addPost() {
        URI uri = uriComponentsBuilder
                .pathSegment("posts")
                .build()
                .toUri();
        RequestEntity<Post> request = RequestEntity.post(uri)
                .body(new Post(3L, null, "Spring", "Java Ohh."));
        ResponseEntity<Post> response = restTemplate.exchange(request, Post.class);
        System.out.println(response.getBody());
    }

    @Test
    void getPostByUserId() {
        URI uri = uriComponentsBuilder
                .pathSegment("posts")
                .queryParam("userId", "2")
                .build()
                .toUri();

        RequestEntity<Void> requestEntity = RequestEntity.get(uri).build();
        ResponseEntity<Post[]> response = restTemplate.exchange(requestEntity, Post[].class);
        List<Post> posts = Arrays.stream(response.getBody()).toList();
        System.out.println(posts);
    }

    @Test
    void updateComment(){
        URI uri = uriComponentsBuilder
                .pathSegment("comments","5")
                .build()
                .toUri();

        RequestEntity<Comment> request = RequestEntity.put(uri).body(new Comment(9L, 5L, "Tlga", "example@gmail.com", "hello"));
        ResponseEntity<Comment> response = restTemplate.exchange(request, Comment.class);
        System.out.println(response.getBody());
    }
}
