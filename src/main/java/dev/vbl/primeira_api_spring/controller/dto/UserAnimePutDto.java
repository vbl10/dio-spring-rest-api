package dev.vbl.primeira_api_spring.controller.dto;

public class UserAnimePutDto {
    private Long userId, animeId;
    private int episodiosAssistidos;
    private String status;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAnimeId() {
        return animeId;
    }

    public void setAnimeId(Long animeId) {
        this.animeId = animeId;
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
