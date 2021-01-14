package com.example.vehicleTrackingSystem.Controller;

import com.example.vehicleTrackingSystem.bean.AuthenticationBean;
import com.example.vehicleTrackingSystem.bean.JwtUserRole;
import com.example.vehicleTrackingSystem.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.vehicleTrackingSystem.service.security.JWTService;
import com.example.vehicleTrackingSystem.service.modelService.userService;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * Created by aishwarya on 1/14/21.
 */

/**
 * Use to generate token for users !!
 */

@RestController
public class AuthenticationToken {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private userService userService;

    @PostMapping(value = "/api/public/token-create")
    public ResponseEntity<?> authenticationToken(@RequestBody AuthenticationBean auth, HttpServletResponse response) {

        String username = auth.getUsername();
        String password = auth.getPassword();
        Integer id = auth.getId();

        Optional<user> user = this.userService.findUserByUsernameAndPassword(username, password,id);

        if (user.isPresent()) {

            JwtUserRole jwtUser = new JwtUserRole(user.get().getUserName(),
                    user.get()
                            .getRolesSet()
                            .stream()
                            .map(u -> u.getRoleName())
                            .collect(Collectors.toSet()));

            return ResponseEntity.ok(jwtService.getToken(jwtUser));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
