package com.example.musicapidemo.controller;


import com.example.musicapidemo.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/music")
@RestController
public class MusicController {

    private final MusicService musicService;

    @GetMapping("/token")
    public void getAccessToken() {
        musicService.getAccessToken();
    }
}
