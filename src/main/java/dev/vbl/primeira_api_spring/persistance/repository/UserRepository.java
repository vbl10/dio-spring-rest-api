package dev.vbl.primeira_api_spring.persistance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.vbl.primeira_api_spring.persistance.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    public Optional<User> findByName(String name);
    public boolean existsByName(String name);
}
