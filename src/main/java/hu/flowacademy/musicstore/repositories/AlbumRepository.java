package hu.flowacademy.musicstore.repositories;

import hu.flowacademy.musicstore.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
