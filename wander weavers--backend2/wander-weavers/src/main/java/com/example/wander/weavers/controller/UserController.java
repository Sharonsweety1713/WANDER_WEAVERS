package com.example.wander.weavers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.wander.weavers.model.User;
import com.example.wander.weavers.repository.UserRepository;
import com.example.wander.weavers.service.UserService;

// @RestController

// public class UserController {

//     @Autowired
//     private UserService userService;

//     @GetMapping("/users")
//     public ResponseEntity<List<User>> getAllUsers() {
//         List<User> users = userService.getAllUsers();
//         return ResponseEntity.ok(users);
//     }

//     @GetMapping("/users/{id}")
//     public ResponseEntity<User> getUserById(@PathVariable Long id) {
//         User user = userService.getUserById(id);
//         return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
//     }

//     @PostMapping("/userss")
//     public ResponseEntity<User> createUser(@RequestBody User user) {
//         User savedUser = userService.createUser(user);
//         return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
//     }

//     // @PutMapping("/users/{id}")
//     // public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updateUser) {
//     //     User updatedUser = userService.updateUser(id, updateUser);
//     //     return updatedUser != null ? ResponseEntity.ok(updatedUser) : ResponseEntity.notFound().build();
//     // }

//     @DeleteMapping("/users/{id}")
//     public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
//         boolean deleted = userService.deleteUser(id);
//         return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
//     }
// }

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    

   

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("username/{username}")

public ResponseEntity<List<User>> getUsersByCity (@PathVariable String username) {

List<User> users = userRepository.findByUsername (username);

return ResponseEntity.ok(users);

}

@GetMapping("/sorted")
public ResponseEntity<List<User>> getUsersSortedByUsername() {
    
    List<User> users = userService.findAllUsersSortedByUsername();
     return ResponseEntity.ok(users);
}

@GetMapping("/page/{offset}/{pagesize}")
    public ResponseEntity<?> gettchild(@PathVariable int offset,@PathVariable int pagesize)
    {
        try
        {
            return new ResponseEntity<>(userService.gettchild(offset,pagesize),HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

   


    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = userService.updateUser(id, updatedUser);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
