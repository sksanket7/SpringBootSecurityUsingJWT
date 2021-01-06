package com.sanket.SpringBootSecurityUsingJWT.controller;

import com.sanket.SpringBootSecurityUsingJWT.entity.AuthenticationRequest;
import com.sanket.SpringBootSecurityUsingJWT.entity.User;
import com.sanket.SpringBootSecurityUsingJWT.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/")
    public String login(){
        return "Welcome to UnderWriter Engine";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthenticationRequest authRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        }catch (Exception exception){
            throw new Exception("Invalid Username or Pssword");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }

}
