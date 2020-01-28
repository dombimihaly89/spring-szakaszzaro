package hu.flowacademy.musicstore.services;

import hu.flowacademy.musicstore.models.Album;
import hu.flowacademy.musicstore.models.Artist;
import hu.flowacademy.musicstore.models.DTOs.AlbumDTO;
import hu.flowacademy.musicstore.models.DTOs.ArtistDTO;
import hu.flowacademy.musicstore.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    public Artist findById(Long id) {
        return artistRepository.findById(id).orElse(null);
    }

    public Artist addArtist(ArtistDTO artistDTO) {
        Artist artist = artistDTO.toEntity();
        return artistRepository.save(artist);
    }

    public void deleteArtist(Long id) {
        artistRepository.deleteById(id);
    }
}
