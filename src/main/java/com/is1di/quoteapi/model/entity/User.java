package com.is1di.quoteapi.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @Column(unique = true)
    private String login;
    private String name;
    private String email;
    /**
     * in prod it must be hashed password as example by BCryptPasswordEncoder
     */
    private String password;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @OneToMany
    private Set<Quote> quotes;
    @OneToMany
    private Set<Vote> votes;
}
