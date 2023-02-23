package com.example.loginApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.loginApp.Entity.User;

@Repository
public interface UtentiRepository extends JpaRepository<User, String>{

}
