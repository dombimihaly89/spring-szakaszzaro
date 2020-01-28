package hu.flowacademy.musicstore.services;

import hu.flowacademy.musicstore.models.Artist;
import hu.flowacademy.musicstore.models.DTOs.SongDTO;
import hu.flowacademy.musicstore.models.Song;
import hu.flowacademy.musicstore.repositories.AlbumRepository;
import hu.flowacademy.musicstore.repositories.ArtistRepository;
import hu.flowacademy.musicstore.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private ArtistService artistService;

    public List<Song> findAll() {
        return songRepository.findAll();
    }

    public Song findById(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    public Song addSong(SongDTO songDTO) {
        Song song = songDTO.toEntity();
        song.setArtist(artistService.findById(songDTO.getArtistId()));
        song.setAlbum(albumService.findById(songDTO.getAlbumId()));
        return songRepository.save(song);
    }

    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }
}
