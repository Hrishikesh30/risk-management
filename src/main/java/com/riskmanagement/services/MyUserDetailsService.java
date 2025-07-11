package com.riskmanagement.services;

import com.riskmanagement.entity.UserEntity;
import com.riskmanagement.repo.UserRepo;
import com.riskmanagement.security.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user= userRepo.findByUsername(username);
        if(user==null){
            System.out.println("User not found with the username:"+username);
            throw new UsernameNotFoundException("Username not found");

        }

        return new UserPrinciple(user);
    }
}
