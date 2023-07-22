package com.example.musicapidemo.dto;

public record SpotifyAlbumResponse(String album_type, int total_tracks, External external_urls,
                                   SpotifyImageResponse[] images, String name, String release_date) {

    public record External(String spotify) {

    }
}
