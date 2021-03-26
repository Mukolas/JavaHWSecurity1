package com.example.security1.controllers;


import com.example.security1.dao.UserDAO;
import com.example.security1.models.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor
public class MainController {
    private UserDAO userDAO;
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String home(Principal principal){
        System.out.println(principal);
        System.out.println(SecurityContextHolder.getContext().getAuthentication());
        return "home";
    }

    @GetMapping("/admin/test")
    public List<String> adminTest(){
        return Arrays.asList("kokos","abrikos");
    }
    @GetMapping("/user/test")
    public List<String> userTest(){
        return Arrays.asList("milk","gorilk");
    }
    @GetMapping("/wide")
    public String wide(){
        return "wide URL";
    }

    @PostMapping("/register")
    public void register (@RequestBody User user){
        System.out.println(user);
        String encode=passwordEncoder.encode(user.getPassword());
        user.setPass(encode);
        System.out.println(user);
        userDAO.save(user);
    }
}
