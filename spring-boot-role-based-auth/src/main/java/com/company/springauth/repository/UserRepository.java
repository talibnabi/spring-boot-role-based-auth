package com.company.springauth.repository;

import com.company.springauth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.username=: username")
    User getUserByUsername(@Param("username") String username);
}
