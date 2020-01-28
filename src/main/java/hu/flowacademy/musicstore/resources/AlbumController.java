package hu.flowacademy.musicstore.resources;


import hu.flowacademy.musicstore.models.Album;
import hu.flowacademy.musicstore.models.DTOs.AlbumDTO;
import hu.flowacademy.musicstore.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping
    List<AlbumDTO> findAll() {
        List<AlbumDTO> listOfDtos = albumService.findAll().stream().map(a -> {
            AlbumDTO albumDTO = new AlbumDTO(a);
            return albumDTO;
        }).collect(Collectors.toList());
        return listOfDtos;
    }

    @GetMapping("/{id}")
    AlbumDTO findById(@PathVariable Long id) {
        Album album = albumService.findById(id);
        AlbumDTO albumDTO = new AlbumDTO(album);
        return albumDTO;
    }

    @PostMapping
    AlbumDTO addAlbum(@RequestBody AlbumDTO albumDTO) {
        Album album = albumService.addAlbum(albumDTO);
        AlbumDTO albumDTO1 = new AlbumDTO(album);
        return albumDTO1;
    }

    @PutMapping
    AlbumDTO updateAlbum(@RequestBody AlbumDTO albumDTO) {
        Album album = albumService.updateAlbum(albumDTO);
        AlbumDTO albumDTO1 = new AlbumDTO(album);
        return albumDTO1;
    }


    @DeleteMapping("/{id}")
    void deleteAlbum(@PathVariable Long id) {
        albumService.deleteAlbum(id);
    }


}
