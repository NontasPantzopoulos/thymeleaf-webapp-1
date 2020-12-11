package com.nontas.spring.thymeleafwebapp1.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "jobs", schema = "public", catalog = "tmsdb")
public class JobsEntity {
    private int jobId;
    private String description;
    private Timestamp startDate;
    private Timestamp endDate;
    private boolean done;
    private String username;
    private UsersEntity usersByUsername;

    public JobsEntity() {
    }

    public JobsEntity(String description, Timestamp startDate, Timestamp endDate, boolean done, String username, UsersEntity usersByUsername) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.done = done;
        this.username = username;
        this.usersByUsername = usersByUsername;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "job_id",nullable = false)
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "description",nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "start_date",nullable = false)
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date")
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "done",nullable = false)
    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Basic
    @Column(name = "username",insertable = false,updatable = false,nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobsEntity that = (JobsEntity) o;
        return jobId == that.jobId && done == that.done && Objects.equals(description, that.description) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, description, startDate, endDate, done, username);
    }

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
    public UsersEntity getUsersByUsername() {
        return usersByUsername;
    }

    public void setUsersByUsername(UsersEntity usersByUsername) {
        this.usersByUsername = usersByUsername;
    }
}
