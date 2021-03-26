package com.example.security1.dao;

import com.example.security1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Integer> {
User findUserByName(String name);
}
