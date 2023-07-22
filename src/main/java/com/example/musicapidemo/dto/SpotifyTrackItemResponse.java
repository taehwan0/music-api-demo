package com.example.musicapidemo.dto;

public record SpotifyTrackItemResponse(Track tracks) {

    public record Track(String href, Item[] items) {

    }
    public record Item(SpotifyAlbumResponse album, SpotifyArtistResponse[] artists) {

    }
}
