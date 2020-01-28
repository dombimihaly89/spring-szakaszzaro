package hu.flowacademy.musicstore.utils;


import hu.flowacademy.musicstore.models.Album;
import hu.flowacademy.musicstore.models.Artist;
import hu.flowacademy.musicstore.models.Song;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.io.*;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
@Slf4j
@AllArgsConstructor
public class InitDataLoader {

    @Autowired
    private JsonLoader jsonLoader;


    @PostConstruct
    public void init() {
        loadArtists();
        loadAlbums();
        loadSongs();
    }

    public void loadArtists() {
        List<Artist> artists = jsonLoader.loadByFilename("artists", List.class, Artist.class);
    }

    public void loadAlbums() {
        List<Album> albums = jsonLoader.loadByFilename("albums", List.class, Album.class);
    }

    public void loadSongs() {
        List<Song> songs = jsonLoader.loadByFilename("songs", List.class, Song.class);
    }


}

