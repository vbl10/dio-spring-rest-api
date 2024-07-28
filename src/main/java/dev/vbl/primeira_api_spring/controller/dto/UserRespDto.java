package dev.vbl.primeira_api_spring.controller.dto;

import java.util.LinkedList;
import java.util.List;

import dev.vbl.primeira_api_spring.persistance.model.Anime;
import dev.vbl.primeira_api_spring.persistance.model.User;
import dev.vbl.primeira_api_spring.persistance.model.UserAnime;

public class UserRespDto {
    private Long id;
    private String name;

    public class UserAnimeDto {
        private Anime anime;
        private int episodiosAssistidos;
        private String status;

        public UserAnimeDto(UserAnime userAnime) {
            this.anime = userAnime.getAnime();
            this.episodiosAssistidos = userAnime.getEpisodiosAssistidos();
            this.status = userAnime.getStatus();
        }

        public Anime getAnime() {
            return anime;
        }
        public void setAnime(Anime anime) {
            this.anime = anime;
        }
        public int getEpisodiosAssistidos() {
            return episodiosAssistidos;
        }
        public void setEpisodiosAssistidos(int episodiosAssistidos) {
            this.episodiosAssistidos = episodiosAssistidos;
        }
        public String getStatus() {
            return status;
        }
        public void setStatus(String status) {
            this.status = status;
        }
    }

    private List<UserAnimeDto> animes;

    public UserRespDto() {}

    public UserRespDto(User user) {
        id = user.getId();
        name = user.getName();
        animes = new LinkedList<>();
        if (user.getAnimes() != null) {
            for (int i = 0; i < user.getAnimes().size(); i++) {
                animes.add(new UserAnimeDto(user.getAnimes().get(i)));
            }
        }
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
    public void setName(String name) {
        this.name = name;
    }
    public List<UserAnimeDto> getAnimes() {
        return animes;
    }
    public void setAnimes(List<UserAnimeDto> animes) {
        this.animes = animes;
    }
}
