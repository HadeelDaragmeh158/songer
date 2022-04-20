package com.example.songr.infrastructure;
import com.example.songr.domain.Song;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
