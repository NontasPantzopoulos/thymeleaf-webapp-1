package com.nontas.spring.thymeleafwebapp1.repository;


import com.nontas.spring.thymeleafwebapp1.model.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, String> {

}
