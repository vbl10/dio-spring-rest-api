package dev.vbl.primeira_api_spring.persistance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.vbl.primeira_api_spring.persistance.model.UserAnime;

@Repository
public interface UserAnimeRepository extends JpaRepository<UserAnime, Long> {
    @Query(value = "SELECT ua.* FROM user_anime AS ua WHERE ua.user_id = :user_id AND ua.anime_id = :anime_id", nativeQuery = true)
    public Optional<UserAnime> findByUserIdAndAnimeId(@Param("user_id") Long userId, @Param("anime_id") Long animeId);
}
