package com.example.demo.controller;

import com.example.demo.bean.JwtResponse;
import com.example.demo.bean.SignInRequest;
import com.example.demo.bean.SignUpRequest;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.security.JwtProvider;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody SignInRequest signInRequest) {

        System.out.println("bonjour "+signInRequest.getEmail());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signInRequest.getEmail(),
                        signInRequest.getPassword()
                )
        );


        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @GetMapping("/user/list")
    public ResponseEntity<?> getListUser(){
        try {
            List<User> liste = userService.findAllUser();
            return new ResponseEntity<>(liste, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userService.findUserByUsername(signUpRequest.getEmail())) {
            return new ResponseEntity<String>("Erreur -> le nom d\'utilisateur existe déjà!",
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(signUpRequest.getFirstname(),signUpRequest.getLastname(), signUpRequest.getEmail(),"", encoder.encode(signUpRequest.getPassword()));

        userService.saveUser(user);
        return ResponseEntity.ok().body("Création d'utilisateur réussie!");
    }
}
