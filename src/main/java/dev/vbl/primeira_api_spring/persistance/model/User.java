package dev.vbl.primeira_api_spring.persistance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity(name = "API_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserAnime> animes;

    public User(String name) { this.name = name; }
    public User() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<UserAnime> getAnimes() {
        return animes;
    }
    public void setAnimes(List<UserAnime> animes) {
        this.animes = animes;
    }
}
