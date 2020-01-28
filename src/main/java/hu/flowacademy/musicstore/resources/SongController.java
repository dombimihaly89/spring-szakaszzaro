package hu.flowacademy.musicstore.resources;

import hu.flowacademy.musicstore.models.Artist;
import hu.flowacademy.musicstore.models.DTOs.ArtistDTO;
import hu.flowacademy.musicstore.models.DTOs.SongDTO;
import hu.flowacademy.musicstore.models.Song;
import hu.flowacademy.musicstore.services.ArtistService;
import hu.flowacademy.musicstore.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping
    List<SongDTO> findAll() {
        List<SongDTO> listOfDtos = songService.findAll().stream().map(s -> {
            SongDTO songDTO = new SongDTO(s);
            return songDTO;
        }).collect(Collectors.toList());
        return listOfDtos;
    }

    @GetMapping("/{id}")
    SongDTO findById(@PathVariable Long id) {
        Song song = songService.findById(id);
        SongDTO songDTO = new SongDTO(song);
        return songDTO;
    }

    @PostMapping
    SongDTO addSong(@RequestBody SongDTO songDTO) {
        Song song = songService.addSong(songDTO);
        SongDTO songDTO1 = new SongDTO(song);
        return songDTO1;
    }

    @DeleteMapping("/{id}")
    void deleteSong(@PathVariable Long id) {
        songService.deleteSong(id);
    }
}
