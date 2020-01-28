package hu.flowacademy.musicstore.models.DTOs;

import hu.flowacademy.musicstore.models.Album;
import lombok.Data;

@Data
public class AlbumDTO {

    private Long id;

    private String title;

    private Long count;

    public AlbumDTO(Album album) {
        this.id = album.getId();
        this.title = album.getTitle();
        this.count = album.getCount();
    }

    public Album toEntity() {
        Album album = new Album();
        album.setId(this.id);
        album.setCount(this.count);
        album.setTitle(this.title);
        return album;
    }
}
