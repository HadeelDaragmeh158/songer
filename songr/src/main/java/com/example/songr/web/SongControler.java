package com.example.songr.web;


import com.example.songr.domain.Album;
import com.example.songr.domain.Song;
import com.example.songr.infrastructure.AlbumRepository;
import com.example.songr.infrastructure.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongControler {

    @Autowired
    SongRepository songRepository;
    @Autowired
    AlbumRepository albumRepository;


    public SongControler(SongRepository songRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
    }

//    @PostMapping("/Album/{id}")
//    public String albume(@PathVariable Long id){
//
//    return "/";
//    }

    @GetMapping("/Album/{id}")
    public String viewAlbumDetailes(@PathVariable Long id, Model model){

        Album album = albumRepository.findById(id).orElseThrow();
        model.addAttribute("album",album);
        model.addAttribute( "songs", album.getSongs());
        return "AlbumDetails";
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("albumList",albumRepository.findAll());
        return "index.html";
    }

    @PostMapping("/Album/{id}/addSong")
    public RedirectView addSong (@ModelAttribute  Song song, @PathVariable Long id){
        Album album = albumRepository.findById(id).orElseThrow();
        song.setAlbum(album);
        songRepository.save(song);
       return  new RedirectView(String.format("/Album/%d", id));
    }





//
//    @GetMapping("/allSongs")
//    public String getSong(Model model){
//
//    }


//
//    /**
//     * Creates a new AlbumS
//     *
//     * @param albom
//     * @return
//     */
//
//        @ResponseBody
//        @PostMapping("/album")
//        Album Createalbum (@RequestBody Album albom){
//            return albumRepository.save(albom);
//        }
//    @ResponseBody
//    @GetMapping("/getallsongs")
//    public List<Song> GetAllSongs(){
//        return (List<Song>) songRepository.findAll();
//    }
//
//    @GetMapping("/songs")
//    public String getAllSongs(Model model){
//        model.addAttribute("songsList",songRepository.findAll());
//        model.addAttribute("albumsList",albumRepository.findAll());
//        return "song";
//    }
//
//    @PostMapping("/song")
//    public RedirectView createNewSong(@RequestParam long album, @ModelAttribute  Song song) {
//        Album foundAlbum = albumRepository.findById(album).orElseThrow();
//        song.setAlbum(foundAlbum);
//        songRepository.save(song);
//        return new RedirectView("/songs");
//    }
//    @ResponseBody
//    @PostMapping("/album/{id}")
//    public Song addNewSongToAlbum(@RequestBody Song song, @PathVariable Long id) {
//        Album album = albumRepository.findById(id).orElseThrow();
//        song.setAlbum(album);
//        return songRepository.save(song);
//    }
}
