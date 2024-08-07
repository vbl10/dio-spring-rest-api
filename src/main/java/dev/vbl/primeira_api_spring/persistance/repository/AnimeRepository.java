package dev.vbl.primeira_api_spring.persistance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.vbl.primeira_api_spring.persistance.model.Anime;;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {
    
    public Optional<Anime> findByName(String name);
    public boolean existsByName(String name);
}
