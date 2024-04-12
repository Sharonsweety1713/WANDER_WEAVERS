package com.example.wander.weavers.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.wander.weavers.model.Role;
import com.example.wander.weavers.model.User;
import com.example.wander.weavers.repository.RoleRepo;
import com.example.wander.weavers.repository.UserRepository;
import java.util.List;
import java.util.Optional;



@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepo roleRepository;

    public User createUser(User user) {
       
        if (user.getRole() != null) {
            roleRepository.save(user.getRole());
        }
        return userRepository.save(user);
    }

    public List<Role> getchild(String field) {
        Sort sort = Sort.by(Sort.Direction.ASC,field);
        return roleRepository.findAll(sort);
    }

    public User getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    public User updateUser(Long id, User updatedUser) {
        Optional<User> existingUserOptional = userRepository.findById(id);
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setRole(updatedUser.getRole());
            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }
    public List<User> gettchild(int offset, int pagesize) {

        Pageable page = PageRequest.of(offset,pagesize);
        return userRepository.findAll(page).getContent();
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> findAllUsersSortedByUsername() {
        return userRepository.findAllUsersSortedByUsername();
    }
    
    
}
