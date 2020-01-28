package hu.flowacademy.musicstore.repositories;

import hu.flowacademy.musicstore.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
