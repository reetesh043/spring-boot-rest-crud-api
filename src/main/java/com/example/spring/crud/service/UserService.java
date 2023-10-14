package com.example.spring.crud.service;


import com.example.spring.crud.exception.UserException;
import com.example.spring.crud.exception.UserNotFoundException;
import com.example.spring.crud.model.User;
import com.example.spring.crud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user) {
        // Check if the username is already taken
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new UserException("Username is already taken");
        }

        // Hash the user's password before storing it in the database
        user.setPassword(user.getPassword());

        // Save the user to the database
        return userRepository.save(user);
    }

    public User updateUserDetails(Long userId, User updatedUser) {
        Optional<User> existingUser = userRepository.findById(userId);

        if (existingUser.isPresent()) {
            User user = existingUser.get();

            // Update user details as needed (e.g., name, email, etc.)
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());

            // Save the updated user to the database
            return userRepository.save(user);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    public User getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();

    }

    public User loadUserByUsername(String username) throws UserNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return user;
    }

    public void deleteUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            userRepository.deleteById(userId);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }
}

