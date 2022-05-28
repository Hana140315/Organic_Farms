package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.models.Farm;
import com.example.demo.models.Role;

import com.example.demo.repositories.FarmRepository;


@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
    private FarmRepository farmRepository;
    
    public UserDetailsServiceImplementation(FarmRepository userRepository){
        this.farmRepository = userRepository;
    }
    // 1
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Farm user = farmRepository.findByfarmName(username);
//        
//        if(user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        
//        return new org.springframework.security.core.userdetails.User(user.getFarmName(), user.getPassword(), getAuthorities(user));
//    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Farm user = farmRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("Not found!");
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthorities(user));
    }

    // 2
    private List<GrantedAuthority> getAuthorities(Farm user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for(Role role : user.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
            authorities.add(grantedAuthority);
        }
        return authorities;
    }
}