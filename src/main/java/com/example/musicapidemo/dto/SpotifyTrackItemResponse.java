package com.example.musicapidemo.dto;

public record SpotifyTrackItemResponse(Track tracks) {

    public record Track(String href, Item[] items) {

        public record Item(Album album, Artist[] artists) {

            public record Artist(String id, String name) {

            }

            public record Album(String album_type,
                                int total_tracks,
                                External external_urls,
                                Image[] images,
                                String name,
                                String release_date) {

                public record Image(String url, int height, int width) {

                }

                public record External(String spotify) {

                }
            }
        }
    }
}
