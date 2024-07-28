package dev.vbl.primeira_api_spring.controller.dto;

public class AnimePostReqDto {
    private String name;
    private Integer episodes;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getEpisodes() {
        return episodes;
    }
    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }
    
}
