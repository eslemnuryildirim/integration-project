package com.example.integrationproject.client;

import com.example.integrationproject.Model.User;
import com.example.integrationproject.Repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserApiClient {

    private final RestTemplate restTemplate;
    private final UserRepository userRepository;

    public UserApiClient(UserRepository userRepository) {
        this.restTemplate = new RestTemplate();
        this.userRepository = userRepository;
    }

    public void fetchAndSaveUsers() {
        String url = "https://jsonplaceholder.typicode.com/users";
        ResponseEntity<User[]> response = restTemplate.getForEntity(url, User[].class);
        User[] users = response.getBody();

        if (users != null) {
            for (User user : users) {
                userRepository.save(user);
                System.out.println("Saved user: " + user.getName());
            }
        } else {
            System.out.println("No users fetched from API.");
        }
    }
}
