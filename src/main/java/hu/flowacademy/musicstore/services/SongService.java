package hu.flowacademy.musicstore.services;

import hu.flowacademy.musicstore.exceptions.ValidationException;
import hu.flowacademy.musicstore.models.Artist;
import hu.flowacademy.musicstore.models.DTOs.AlbumDTO;
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
        titleValidation(songDTO);
        artistAlbumGenreEmptinessValidation(songDTO);
        lengthValidation(songDTO);
        if (songDTO.getLyrics() == "") {
            songDTO.setLyrics(null);
        }
        if (songDTO.getWriterName() == "" || songDTO.getWriterName() == null) {
            String firstName = artistService.findById(songDTO.getArtistId()).getFirstName();
            String lastName = artistService.findById(songDTO.getArtistId()).getLastName();
            songDTO.setWriterName(firstName + " " + lastName);
        }
        Song song = songDTO.toEntity();
        song.setArtist(artistService.findById(songDTO.getArtistId()));
        song.setAlbum(albumService.findById(songDTO.getAlbumId()));
        return songRepository.save(song);
    }

    public Song updateSong(SongDTO songDTO) {
        Song song = songDTO.toEntity();
        song.setArtist(artistService.findById(songDTO.getArtistId()));
        song.setAlbum(albumService.findById(songDTO.getAlbumId()));
        return songRepository.save(song);
    }

    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }

    public void titleValidation(SongDTO songDTO) {
        if (songDTO.getTitle() == "") {
            throw new ValidationException("Title cannot be empty");
        }
    }

    public void artistAlbumGenreEmptinessValidation(SongDTO songDTO) {
        if (songDTO.getArtistId() == null) {
            throw new ValidationException("Artist cannot be null");
        }
        if (songDTO.getAlbumId() == null) {
            throw new ValidationException("Album cannot be null");
        }
        if (songDTO.getGenre() == null) {
            throw new ValidationException("Genre cannot be null");
        }
    }

    public void lengthValidation(SongDTO songDTO) {
        if (songDTO.getLength() <= 0) {
            throw new ValidationException("Length must be bigger than 0");
        }
    }


}
