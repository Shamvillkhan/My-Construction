package com.construction.sk.service;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.construction.sk.entity.Users;
import com.construction.sk.repository.UserRepository;
 

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    
    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    
    public Users getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> userOpt = userRepository.findByUsername(username);
        System.out.print("hello1");

        if (userOpt.isPresent()) {
            var user = userOpt.get();
            
            System.out.print("hello2");
            return User.builder()
            		.username(user.getUsername())
            		.password(user.getPassword())
            		.build();
        }else {
        	
        	throw new UsernameNotFoundException("User not found with username: " + username);
        }

    }

    
    public Users updateUser(Long id, Users updatedUser) {
        Users existingUser = getUserById(id);
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        return userRepository.save(existingUser);
    }

    
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
