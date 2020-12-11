package com.nontas.spring.thymeleafwebapp1.model;

import com.sun.istack.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "public", catalog = "tmsdb")
public class UsersEntity {
    private String username;
    private String fName;
    private String lName;
    private String password;
    private Collection<JobsEntity> jobsByUsername;


    public UsersEntity(String username, String fName, String lName, String password) {
        this.username = username;
        this.fName = fName;
        this.lName = lName;
        this.password = password;
    }

    public UsersEntity() {

    }

    @Id
    @Column(name = "username",nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "f_name",nullable = false)
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    @Basic
    @Column(name = "l_name",nullable = false)
    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Basic
    @Column(name = "password",nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return Objects.equals(username, that.username) && Objects.equals(fName, that.fName) && Objects.equals(lName, that.lName) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, fName, lName, password);
    }

    @OneToMany(mappedBy = "username",targetEntity = JobsEntity.class,fetch = FetchType.EAGER)
    public Collection<JobsEntity> getJobsByUsername() {
        return jobsByUsername;
    }

    public void setJobsByUsername(Collection<JobsEntity> jobsByUsername) {
        this.jobsByUsername = jobsByUsername;
    }
}
