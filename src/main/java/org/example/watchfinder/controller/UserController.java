package org.example.watchfinder.controller;

import org.example.watchfinder.dto.Item;
import org.example.watchfinder.model.User;
import org.example.watchfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /*@GetMapping("/getprofile")
    public ResponseEntity<User> getProfile() {

    }*/

    @PostMapping("/addtolist")
    public ResponseEntity<String> addToList(@RequestBody Item item, Authentication auth) {
        if (auth == null || !auth.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
        }
        String username = auth.getName();
        if(userService.addItem(username, item)){
            return ResponseEntity.status(HttpStatus.CREATED).body("Item added");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error adding new item");
        }

    }
}

