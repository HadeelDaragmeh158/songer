package com.example.songr.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;



@JsonIgnoreProperties({"album"})
@Entity
public class Song {
    @Setter(value = AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String title;

    @NonNull
    private int length;

    @NonNull
    private int trackNumber;

    @ManyToOne
    Album album;

    public Song(String title, int length, int trackNumber) {
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
    }

    public Song() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }


}
