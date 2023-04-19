package com.example.SpringSecurityDemo.entity;


import jakarta.persistence.*;

@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq")
    Long id;
    String name;
    String username;
    String password;
    int idDesignation; // 0 for admin; 1 for employee; 2 for manager etc

    public User()
    {
        // Default Constructor
    }

    public User(String name, String username, String password, int idDesignation) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.idDesignation = idDesignation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdDesignation() {
        return idDesignation;
    }

    public void setIdDesignation(int idDesignation) {
        this.idDesignation = idDesignation;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", idDesignation=" + idDesignation +
                '}';
    }
}
