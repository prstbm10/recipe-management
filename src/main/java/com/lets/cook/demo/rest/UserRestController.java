package com.lets.cook.demo.rest;

import com.lets.cook.demo.entity.User;
import com.lets.cook.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserRestController {
    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Object> getUsers() {
        try {
            List<User> users = userService.findUsers();
            return ResponseEntity.ok().body(users);
        } catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }


    @PostMapping("create")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        try {
            User create = userService.create(user);
            return ResponseEntity.status(200).body("created user with id "+ create.getId());
        } catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("update")
    public ResponseEntity<Object> updateUser(@RequestBody User user) {
        try {
            String update = userService.update(user);
            return ResponseEntity.status(200).body(update);
        } catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("delete")
    public ResponseEntity<Object> deleteUser(@RequestParam Long id) {
        try {
            return ResponseEntity.status(200).body(userService.delete(id));
        } catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
