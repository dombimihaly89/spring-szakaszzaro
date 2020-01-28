package hu.flowacademy.musicstore.resources;

import hu.flowacademy.musicstore.models.Album;
import hu.flowacademy.musicstore.models.Artist;
import hu.flowacademy.musicstore.models.DTOs.AlbumDTO;
import hu.flowacademy.musicstore.models.DTOs.ArtistDTO;
import hu.flowacademy.musicstore.services.AlbumService;
import hu.flowacademy.musicstore.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping
    List<ArtistDTO> findAll() {
        List<ArtistDTO> listOfDtos = artistService.findAll().stream().map(a -> {
            ArtistDTO artistDTO = new ArtistDTO(a);
            return artistDTO;
        }).collect(Collectors.toList());
        return listOfDtos;
    }

    @GetMapping("/{id}")
    ArtistDTO findById(@PathVariable Long id) {
        Artist artist = artistService.findById(id);
        ArtistDTO artistDTO = new ArtistDTO(artist);
        return artistDTO;
    }

    @PostMapping
    ArtistDTO addArtist(@RequestBody ArtistDTO artistDTO) {
        Artist artist = artistService.addArtist(artistDTO);
        ArtistDTO artistDTO1 = new ArtistDTO(artist);
        return artistDTO1;
    }

    @PutMapping
    ArtistDTO updateArtist(@RequestBody ArtistDTO artistDTO) {
        Artist artist = artistService.updateArtist(artistDTO);
        ArtistDTO artistDTO1 = new ArtistDTO(artist);
        return artistDTO1;
    }

    @DeleteMapping("/{id}")
    void deleteAlbum(@PathVariable Long id) {
        artistService.deleteArtist(id);
    }
}
