package com.sanket.SpringBootSecurityUsingJWT.repository;

import com.sanket.SpringBootSecurityUsingJWT.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoy extends JpaRepository<User, Integer> {
    User findByUserName(String userName);
}
