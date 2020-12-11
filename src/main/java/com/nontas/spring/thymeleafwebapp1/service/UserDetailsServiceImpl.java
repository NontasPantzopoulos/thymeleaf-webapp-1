package com.nontas.spring.thymeleafwebapp1.service;

import com.nontas.spring.thymeleafwebapp1.model.UsersEntity;
import com.nontas.spring.thymeleafwebapp1.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<UsersEntity> userEntity = usersRepository.findById(s);
        if(userEntity.isPresent()){
            UsersEntity user = userEntity.get();
            return User.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .roles("ADMIN")
                    .build();
        }
        else {
            throw new UsernameNotFoundException("Invlaid User");
        }

    }
}
