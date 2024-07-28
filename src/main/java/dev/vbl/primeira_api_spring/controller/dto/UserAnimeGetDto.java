package dev.vbl.primeira_api_spring.controller.dto;

import dev.vbl.primeira_api_spring.persistance.model.Anime;

public class UserAnimeGetDto {
    private Anime anime;
    private int episodiosAssistidos;
    private String status;
    
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
