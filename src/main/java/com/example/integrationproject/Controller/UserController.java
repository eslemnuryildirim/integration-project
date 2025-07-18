package com.example.integrationproject.Controller;

import com.example.integrationproject.Model.User;
import com.example.integrationproject.Repository.UserRepository;
import com.example.integrationproject.client.UserApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final UserApiClient userApiClient;

    @Autowired
    public UserController(UserRepository userRepository, UserApiClient userApiClient) {
        this.userRepository = userRepository;
        this.userApiClient = userApiClient;
    }

    // 1. Veritabanındaki tüm kullanıcıları getir
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 2. API'den veri çekip DB'ye kaydet (manuel tetikleme)
    @PostMapping("/fetch")
    public String fetchFromApi() {
        userApiClient.fetchAndSaveUsers();
        return "Veriler API'den çekildi ve kaydedildi.";
    }
}
