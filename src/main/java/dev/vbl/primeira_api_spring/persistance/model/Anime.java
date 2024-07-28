package dev.vbl.primeira_api_spring.persistance.model;

import dev.vbl.primeira_api_spring.controller.dto.AnimePostReqDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Anime {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer episodes;
    
    public Anime() {}

    public Anime(AnimePostReqDto animeToCreate) {
        this.name = animeToCreate.getName();
        this.episodes = animeToCreate.getEpisodes();
    }


    @Override
    public int hashCode() {
        return id.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Anime other = (Anime) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String nome) {
        this.name = nome;
    }
    public Integer getEpisodes() {
        return episodes;
    }
    public void setEpisodes(Integer episodios) {
        this.episodes = episodios;
    }

    
}
