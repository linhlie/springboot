package com.example.demoSpring.controller;

import com.example.demoSpring.model.User;
import com.example.demoSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> list(Model model) {
        model.addAttribute("users", userService.findAll());
        return userService.findAll();
    }
    @RequestMapping(method = RequestMethod.POST,value = "/users")
    public ResponseEntity create(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id) {
        Optional<User> list = userService.findById(id);
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return "OK";
    }
}
