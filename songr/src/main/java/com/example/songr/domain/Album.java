package com.example.songr.domain;
import lombok.*;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static lombok.AccessLevel.NONE;

@Setter
@Getter
@Entity
public class Album {
  @Setter(value =AccessLevel.NONE)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id ", nullable = false )
  private Long id ;

  @NonNull
  private String title,artist ;

  @NonNull
  private int SongerCount ;

  @NonNull
  private int length;

  @NonNull
  private String imageUrl ;

  public Album(@NonNull String title, @NonNull String artist, @NonNull int songerCount, @NonNull int length, @NonNull String imageUrl) {
    this.title = title;
    this.artist = artist;
    this.SongerCount = songerCount;
    this.length = length;
    this.imageUrl = imageUrl;
  }

  public Album() {}

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public int getSongerCount() {
    return SongerCount;
  }

  public void setSongerCount(int songerCount) {
    SongerCount = songerCount;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public Long getId() {
    return id;
  }

  @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", SongerCount=" + SongerCount +
                ", length=" + length +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
