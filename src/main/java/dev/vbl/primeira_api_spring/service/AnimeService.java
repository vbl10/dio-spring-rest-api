package dev.vbl.primeira_api_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import dev.vbl.primeira_api_spring.persistance.repository.AnimeRepository;
import dev.vbl.primeira_api_spring.persistance.model.Anime;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AnimeService {
    
    @Autowired
    private AnimeRepository animeRepository;

    public Anime create(Anime animeToCreate) {
        animeToCreate.setId(null);
        if (animeRepository.existsByName(animeToCreate.getName()))
            throw new IllegalArgumentException("Given anime name already exists");
        return animeRepository.save(animeToCreate);
    }

    public List<Anime> getSomeAnimes(int pageNumber, int pageSize) {
        return animeRepository.findAll(PageRequest.of(pageNumber, pageSize)).getContent();
    }

    public Anime getByName(String name) {
        return animeRepository.findByName(name).orElseThrow(() -> new NoSuchElementException("There is no such anime with the given name"));
    }

    public Anime getById(Long id) {
        return animeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("There is no such anime with the given id"));
    }
}
