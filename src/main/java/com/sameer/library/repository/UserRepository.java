package com.sameer.library.repository;

import com.sameer.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // This special line helps us find a user when they try to log in!
    User findByUsername(String username);
}