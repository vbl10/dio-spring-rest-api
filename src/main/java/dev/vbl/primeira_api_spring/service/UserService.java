package dev.vbl.primeira_api_spring.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.vbl.primeira_api_spring.persistance.repository.*;
import dev.vbl.primeira_api_spring.controller.dto.*;
import dev.vbl.primeira_api_spring.persistance.model.*;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AnimeRepository animeRepository;
    @Autowired
    private UserAnimeRepository userAnimeRepository;

    public User create(String userToCreate) {
        if (userRepository.existsByName(userToCreate))
            throw new IllegalArgumentException("Username taken");
        return userRepository.save(new User(userToCreate));
    }

    public User findByName(String name) {
        return userRepository.findByName(name).orElseThrow(() -> new NoSuchElementException("Username does not exist"));
    }

    public UserAnime addAnime(UserAnimePutDto dto) {
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new NoSuchElementException("There is no user with the given id"));
        Anime anime = animeRepository.findById(dto.getAnimeId()).orElseThrow(() -> new NoSuchElementException("There is no anime with the given id"));
        
        UserAnime userAnime = userAnimeRepository.findByUserIdAndAnimeId(user.getId(), anime.getId()).orElse(new UserAnime());
        userAnime.setUser(user);
        userAnime.setAnime(anime);
        userAnime.setEpisodiosAssistidos(dto.getEpisodiosAssistidos());
        userAnime.setStatus(dto.getStatus());
        return userAnimeRepository.save(userAnime);
    }
}
