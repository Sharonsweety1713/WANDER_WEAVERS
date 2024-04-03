package com.example.wander.weavers.controller;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.example.wander.weavers.model.User;
// import com.example.wander.weavers.repository.UserRepository;

// import java.util.List;
// import java.util.Optional;

// @RestController
// @RequestMapping("/api")
// @CrossOrigin("*")
// public class UserController {

//     @Autowired
//     private UserRepository userRepository;

//     @GetMapping("/userss")
//     public ResponseEntity<List<User>> getAllUsers() {
//         List<User> users = userRepository.findAll();
//         return ResponseEntity.ok(users);
//     }

//     @GetMapping("/users/{id}")
//     public ResponseEntity<User> getUserById(@PathVariable Long id) {
//         Optional<User> optionalUser = userRepository.findById(id);
//         return optionalUser.map(ResponseEntity::ok)
//                           .orElse(ResponseEntity.notFound().build());
//     }

//     @PostMapping("/users")
//     public ResponseEntity<User> createUser(@RequestBody User user) {
//         User savedUser = userRepository.save(user);
//         return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
//     }

//     @PutMapping("/users/{id}")
//     public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updateUser) {
//         Optional<User> optionalUser = userRepository.findById(id);
//         if (optionalUser.isPresent()) {
//             User user = optionalUser.get();
//             user.setUsername(updateUser.getUsername());
//             user.setEmail(updateUser.getEmail());
//             // Update other fields as needed
//             User updatedUser = userRepository.save(user);
//             return ResponseEntity.ok(updatedUser);
//         }
//         return ResponseEntity.notFound().build();
//     }

//     @DeleteMapping("/users/{id}")
//     public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//         Optional<User> optionalUser = userRepository.findById(id);
//         if (optionalUser.isPresent()) {
//             userRepository.deleteById(id);
//             return ResponseEntity.noContent().build();
//         }
//         return ResponseEntity.notFound().build();
//     }
// }
// UserController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.wander.weavers.model.User;
import com.example.wander.weavers.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PostMapping("/userss")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updateUser) {
        User updatedUser = userService.updateUser(id, updateUser);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        boolean deleted = userService.deleteUser(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
