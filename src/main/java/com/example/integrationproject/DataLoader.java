package com.example.integrationproject;

import com.example.integrationproject.client.UserApiClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserApiClient userApiClient;

    public DataLoader(UserApiClient userApiClient) {
        this.userApiClient = userApiClient;
    }

    @Override
    public void run(String... args) throws Exception {
        userApiClient.fetchAndSaveUsers();
    }
}
