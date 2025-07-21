package com.example.integrationproject.Controller;
import com.example.integrationproject.Model.User;
import com.example.integrationproject.Repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserPageController {

    private final UserRepository userRepository;

    public UserPageController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users/page")
    public String showUsersPage(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users"; // src/main/resources/templates/users.html
    }
    @GetMapping("/users/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        User user = userRepository.findById(id).get(); // basit kullanım
        model.addAttribute("user", user);
        return "user-edit";
    }

    @PostMapping("/users/{id}/edit")
    public String saveUser(@PathVariable Long id, @ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/users/page";
    }




}
