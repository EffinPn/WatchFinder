package org.example.watchfinder.repository;

import org.example.watchfinder.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
        boolean existsByEmail(String email);
        boolean existsByUsername(String username);
        Optional<User> findByUsername(String username);
        Optional<User> findByEmail(String email);
}
