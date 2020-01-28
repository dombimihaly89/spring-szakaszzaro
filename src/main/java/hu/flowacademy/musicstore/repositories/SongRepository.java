package hu.flowacademy.musicstore.repositories;

import hu.flowacademy.musicstore.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
