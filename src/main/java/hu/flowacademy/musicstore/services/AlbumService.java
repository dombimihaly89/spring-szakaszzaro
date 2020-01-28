package hu.flowacademy.musicstore.services;

import hu.flowacademy.musicstore.models.Album;
import hu.flowacademy.musicstore.models.DTOs.AlbumDTO;
import hu.flowacademy.musicstore.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.server.ServerEndpoint;
import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    public Album findById(Long id) {
        return albumRepository.findById(id).orElse(null);
    }

    public Album addAlbum(AlbumDTO albumDTO) {
        Album album = albumDTO.toEntity();
        return albumRepository.save(album);
    }

    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }

    public Album updateAlbum(AlbumDTO albumDTO) {
        Album album = albumDTO.toEntity();
        return albumRepository.save(album);
    }
}
