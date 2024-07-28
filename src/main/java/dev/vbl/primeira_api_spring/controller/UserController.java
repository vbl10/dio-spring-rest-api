package dev.vbl.primeira_api_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.vbl.primeira_api_spring.controller.dto.*;
import dev.vbl.primeira_api_spring.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/{name}")
    public ResponseEntity<UserRespDto> getUser(@PathVariable("name") String name) {        
        return ResponseEntity.ok(new UserRespDto(userService.findByName(name)));
    }

    @PostMapping
    public ResponseEntity<UserRespDto> createUser(@RequestBody UserPostReqDto userToCreate) {
        return ResponseEntity.ok(new UserRespDto(userService.create(userToCreate.getName())));
    }

    @PutMapping("/anime")
    public void addUserAnime(@RequestBody UserAnimePutDto dto) {
        userService.addAnime(dto);
    }
}
