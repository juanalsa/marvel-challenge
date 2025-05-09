package com.test.api.marvel_challenge.persistence.repository;

import com.test.api.marvel_challenge.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
