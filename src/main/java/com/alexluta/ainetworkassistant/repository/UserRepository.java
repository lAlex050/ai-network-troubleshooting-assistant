package com.alexluta.ainetworkassistant.repository;

import com.alexluta.ainetworkassistant.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.email = :email")
    Optional<User> findUserByEmail(@Param("email") String email);

    @Query("select u from User u where u.username = :username")
    Optional<User> findUserByUsername(@Param("username") String username);

    @Query("select u from User u where u.phoneNumber = :phoneNumber")
    Optional<User> findUserByPhoneNumber(@Param("phoneNumber") String phoneNumber);


    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);


}
