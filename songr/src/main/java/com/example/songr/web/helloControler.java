package com.example.songr.web;
import com.example.songr.domain.Album;
import com.example.songr.infrastructure.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller

public class helloControler {
    @Autowired
     AlbumRepository albumRepository;

    @GetMapping("/hello")
    public String  helloWorld (){
    return "helloWorld";
 }

    @GetMapping("/capitalize/{name}")
    public String upperCase(@PathVariable(name="name") String name , Model model) {
     name = name.toUpperCase();
     model.addAttribute("name" , name);
     return "capitalize";
 }

//    @ResponseBody
//    @GetMapping("/Album")
//    public ArrayList<Album> album (){
//        Album album1c = new Album("Hadeel","somth", 15, 6,"www.google.com");
//        Album album2c = new Album("bbb","qwe", 1, 2,"www.facebook.com");
//        Album album3c = new Album("ef","somlth", 10, 10,"www.w3school.com");
//
//        ArrayList<Album> listData= new ArrayList<>();
//        listData.add(album1c);
//        listData.add(album2c);
//        listData.add(album3c);
//        System.out.println(listData);
//    return listData;
//}

//    @ResponseBody
//    @GetMapping("/Album")
//    public ArrayList<String> album (){
//        Album album1c = new Album("Hadeel","somth", 15, 6,"www.google.com");
//        Album album2c = new Album("bbb","qwe", 1, 2,"www.facebook.com");
//        Album album3c = new Album("ef","somlth", 10, 10,"www.w3school.com");
//
//        ArrayList<String> listData= new ArrayList<>();
//        listData.add("album1c "+album1c);
//        listData.add("album2c "+album2c);
//        listData.add("album3c "+album3c);
//        System.out.println(listData);
//        return listData;
//    }

    @PostMapping("/addAlbum")
    public RedirectView createNewAlbum(@ModelAttribute Album album){
        albumRepository.save(album);
        return new RedirectView("/allalbums");
    }

    @GetMapping("/allalbums")
    public String getAllStudents(Model model){
        model.addAttribute("albumList",albumRepository.findAll());
        return "index";
    }



}
