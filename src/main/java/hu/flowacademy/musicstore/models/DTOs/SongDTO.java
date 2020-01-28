package hu.flowacademy.musicstore.models.DTOs;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import hu.flowacademy.musicstore.models.Album;
import hu.flowacademy.musicstore.models.Artist;
import hu.flowacademy.musicstore.models.Genre;
import hu.flowacademy.musicstore.models.Song;
import lombok.Data;

import javax.persistence.OneToOne;
import java.time.LocalDate;

@Data
public class SongDTO {

    private Long id;

    private String title;

    private Long length;

    private String lyrics;

    private LocalDate year;

    private String writerName;

    private Genre genre;

    private Long artistId;

    private Long albumId;

    public SongDTO(Song song) {
        this.id = song.getId();
        this.title = song.getTitle();
        this.length = song.getLength();
        this.lyrics = song.getLyrics();
        this.year = song.getYear();
        this.writerName = song.getWriterName();
        this.genre = song.getGenre();
        this.artistId = song.getArtist().getId();
        this.albumId = song.getAlbum().getId();
    }

    public Song toEntity() {
        Song song = new Song();
        song.setId(this.id);
        song.setTitle(this.title);
        song.setLength(this.length);
        song.setLyrics(this.lyrics);
        song.setYear(this.year);
        song.setWriterName(this.writerName);
        song.setGenre(this.genre);
        //itt még két field nicns beállítva
        //majd a service-ben lesz.
        return song;
    }

}
