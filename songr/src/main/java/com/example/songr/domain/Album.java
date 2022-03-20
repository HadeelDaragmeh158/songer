package com.example.songr.domain;

public class Album {
//    artist, a songCount, a length (in seconds), and an imageUrl that is a link to that album’s art.
    private String title,artist ;
    private int SongerCount ,length;
    private String imageUrl ;

    public Album(String title, String artist, int songerCount, int length, String imageUrl) {
        this.title = title;
        this.artist = artist;
        SongerCount = songerCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getSongerCount() {
        return SongerCount;
    }

    public int getLength() {
        return length;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setSongerCount(int songerCount) {
        SongerCount = songerCount;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
