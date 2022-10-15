package com.niit.user.repository;

import com.niit.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByUserEmailAndPassword(String userEmail, String password);

}
