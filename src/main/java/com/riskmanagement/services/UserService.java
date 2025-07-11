package com.riskmanagement.services;

import com.riskmanagement.dto.LoginRequestDTO;
import com.riskmanagement.entity.UserEntity;
import com.riskmanagement.repo.ApplicationRepo;
import com.riskmanagement.repo.UserRepo;
import com.riskmanagement.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final  PasswordEncoder  bEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    @Autowired
    public UserService(UserRepo userRepo, ApplicationRepo applicationRepo, PasswordEncoder bEncoder, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userRepo=userRepo;
        this.bEncoder = bEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public UserEntity register(UserEntity user) {
        user.setPassword(bEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public String verify(LoginRequestDTO user) {
        Authentication auth= authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken
                        (user.getUsername(),user.getPassword()));
        if(auth.isAuthenticated()){
            return jwtUtil.generateToken(user.getUsername()) ;
        }
        return "fails";
    }
}
