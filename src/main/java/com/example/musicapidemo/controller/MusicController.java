package com.example.musicapidemo.controller;


import com.example.musicapidemo.dto.SpotifyTokenResponse;
import com.example.musicapidemo.dto.SpotifyTrackItemResponse;
import com.example.musicapidemo.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/music")
@RestController
public class MusicController {

    private final MusicService musicService;

    @GetMapping("/token")
    public ResponseEntity<SpotifyTokenResponse> getAccessToken() {
        return ResponseEntity.ok(musicService.getAccessToken());
    }

//    limit 10, type track, market KR 고정
    @GetMapping("/search")
    public ResponseEntity<SpotifyTrackItemResponse> searchMusic(@RequestParam("q") String query, @RequestParam("offset") int offset) {
        return ResponseEntity.ok(musicService.searchMusic(query, offset));
    }
}
