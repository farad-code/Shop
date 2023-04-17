package com.example.product.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.product.Entities.User;

@Repository
public interface UserDao extends JpaRepository<User,Long>{
    Optional<User> findByEmail(String email);
}
