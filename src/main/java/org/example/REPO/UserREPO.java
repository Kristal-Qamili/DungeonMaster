package org.example.REPO;

import org.example.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserREPO extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
