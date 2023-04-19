package com.example.SpringSecurityDemo.repository;

import com.example.SpringSecurityDemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface UserRepo extends JpaRepository<User, Long>
{
    User getByUsername(String username);
}
