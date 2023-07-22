package com.example.musicapidemo.service;

import com.example.musicapidemo.dto.SpotifyTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class MusicService {

    private static final String TOKEN_REQUEST_URL = "https://accounts.spotify.com/api/token";

    @Value("${spotify.client.id}")
    private String SPOTIFY_CLIENT_ID;
    @Value("${spotify.client.secret}")
    private String SPOTIFY_CLIENT_SECRET;

    public void getAccessToken() {
        String body =
            "grant_type=client_credentials&client_id=" + SPOTIFY_CLIENT_ID + "&client_secret=" + SPOTIFY_CLIENT_SECRET;

        WebClient webClient = WebClient.builder()
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
            .build();

        System.out.println(body);
        Mono<SpotifyTokenResponse> responseMono = webClient.post()
            .uri(TOKEN_REQUEST_URL)
            .body(BodyInserters.fromValue(body))
            .retrieve()
            .bodyToMono(SpotifyTokenResponse.class);

        responseMono.subscribe(
            response -> {
                System.out.println(response);
            },
            error -> {
                System.out.println(error);
            }
        );
    }
}
