package com.example.demo.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    // =========================
    // PRIMARY KEY
    // =========================

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // =========================
    // COLUMNS
    // =========================

    @Column(nullable = false, length = 120)
    private String name;

    @Column(nullable = false, unique = true, length = 180)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean active = true;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // =========================
    // CONSTRUCTORS
    // =========================

    public User() {
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.active = true;
    }

    // =========================
    // JPA HOOKS
    // =========================

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // =========================
    // GETTERS
    // =========================

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getActive() {
        return active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // =========================
    // SETTERS
    // =========================

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    public void setEmail(String email) {

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }

        this.email = email;
    }

    public void setPassword(String password) {

        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Password must have at least 6 characters");
        }

        this.password = password;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // =========================
    // CUSTOM METHODS
    // =========================

    public void deactivate() {
        this.active = false;
    }

    public void activate() {
        this.active = true;
    }

    
    // =========================
    // RELATIONSHIPS
    // =========================
    
    // ONE USER -> MANY NOTES
    @OneToMany(mappedBy = "user")
    private List<Note> notes = new ArrayList<>();

    // =========================
    // TO STRING
    // =========================

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", active=" + active +
                ", createdAt=" + createdAt +
                '}';
    }
}