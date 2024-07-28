package dev.vbl.primeira_api_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.vbl.primeira_api_spring.service.AnimeService;
import dev.vbl.primeira_api_spring.controller.dto.AnimePostReqDto;
import dev.vbl.primeira_api_spring.persistance.model.Anime;

import java.util.List;

@RestController
@RequestMapping("/animes")
public class AnimeController {
    
    @Autowired
    private AnimeService animeService;

    @GetMapping
    public ResponseEntity<List<Anime>> getSomeAnimes(
        @RequestParam(name = "name", required = false) String name,
        @RequestParam(name = "id", required = false) Long id,
        @RequestParam(name = "offset", defaultValue = "0") int offset,
        @RequestParam(name = "limit", defaultValue = "20") int limit
        ) {
        if (name != null) 
            return ResponseEntity.ok(List.of(animeService.getByName(name)));
        else if (id != null)
            return ResponseEntity.ok(List.of(animeService.getById(id)));
        return ResponseEntity.ok(animeService.getSomeAnimes(offset, limit));
    }

    @PostMapping
    public ResponseEntity<Anime> addAnime(@RequestBody AnimePostReqDto animeToCreate) {
        return ResponseEntity.ok(animeService.create(new Anime(animeToCreate)));
    }
}
