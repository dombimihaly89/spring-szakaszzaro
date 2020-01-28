package hu.flowacademy.musicstore.repositories;

import hu.flowacademy.musicstore.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
}
