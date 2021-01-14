package com.example.vehicleTrackingSystem.service.modelService;

import com.example.vehicleTrackingSystem.dao.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.vehicleTrackingSystem.entity.user;
import com.example.vehicleTrackingSystem.service.security.PasswordService;
import java.util.List;
import java.util.Optional;

/**
 * Created by aishwarya on 1/14/21.
 */

@Service
public class userService {

    @Autowired
    userRepository userRepository;

    @Autowired
    private PasswordService passwordService;

    public List<user> getAllUsers(){
        return (List<user>) userRepository.getAllUsers();
    }


    public user findUserByUserId(Integer id) {
        return this.userRepository.getUserByID(id);
    }

    public Optional<user> findUserByUsernameAndPassword(String username, String password,Integer id) {

        user user = this.findUserByUserId(id);

        return this.passwordService.equals(password, user.getUserPassword()) ? Optional.of(user) : Optional.empty();
    }
}
