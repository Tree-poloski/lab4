package com.example.demo.Controller;

import com.example.demo.models.UserProfile;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    UserService userProfileService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping
    public List<UserProfile> getAllUsers() {
        return userProfileService.getAllUsers();
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/{id}")
    public UserProfile getUserById(@PathVariable int id) {
        return userProfileService.getUser(id);
    }

}
