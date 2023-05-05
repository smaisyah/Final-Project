package com.mii.merodata.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mii.merodata.models.User;
import com.mii.merodata.repositories.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {
    private UserRepository userRepository;
    

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Integer id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Data User not found!!!"));
    }
    public User create(User user) {
        return userRepository.save(user);
    }

    // public User update(Integer id, User user) {
    //     getById(id); // method getById
    //     user.setId(id);
    //     user.setPassword(passwordEncoder.encode(user.getPassword()));
    //     return userRepository.save(user);
    // }

    public User delete(Integer id) {
        User user = getById(id);
        userRepository.delete(user);
        return user;
    }
}
