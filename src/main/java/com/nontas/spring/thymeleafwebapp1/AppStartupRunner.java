package com.nontas.spring.thymeleafwebapp1;

import com.nontas.spring.thymeleafwebapp1.model.UsersEntity;
import com.nontas.spring.thymeleafwebapp1.repository.JobsRepository;
import com.nontas.spring.thymeleafwebapp1.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class AppStartupRunner implements ApplicationRunner {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private JobsRepository jobsRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Optional<UsersEntity> adminuser = usersRepository.findById("admin");
        if(!adminuser.isPresent()){
            UsersEntity usersEntity = new UsersEntity();
            usersEntity.setUsername("admin");
            usersEntity.setPassword(passwordEncoder.encode("admin"));
            usersEntity.setfName("Administrator");
            usersEntity.setlName("Administrator");
            usersRepository.saveAndFlush(usersEntity);
        }

    }
}
