package hu.flowacademy.musicstore.models.DTOs;

import hu.flowacademy.musicstore.models.Album;
import hu.flowacademy.musicstore.models.Artist;
import lombok.Data;

@Data
public class ArtistDTO {

    private Long id;

    private String firstName;

    private String lastName;

    public ArtistDTO(Artist artist) {
        this.id = artist.getId();
        this.firstName = artist.getFirstName();
        this.lastName = artist.getLastName();
    }

    public Artist toEntity() {
        Artist artist = new Artist();
        artist.setId(this.id);
        artist.setFirstName(this.firstName);
        artist.setLastName(this.lastName);
        return artist;
    }
}
