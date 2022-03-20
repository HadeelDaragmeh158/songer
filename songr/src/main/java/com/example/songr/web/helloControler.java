package com.example.songr.web;

import com.example.songr.domain.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Locale;

@Controller

public class helloControler {
    @GetMapping("/hello")
 public String  helloWorld (){
    return "helloWorld";
 }

 @GetMapping("/capitalize/{name}")
    public String upperCase( @PathVariable(name="name") String name , Model model) {
     name = name.toUpperCase();
     model.addAttribute("name" , name);
     return "capitalize";
 }
    @ResponseBody
    @GetMapping("/Album")
    public ArrayList<Album> album (){
        Album album1c = new Album("Hadeel","somth", 15, 6,"www.google.com");
        Album album2c = new Album("bbb","qwe", 1, 2,"www.facebook.com");
        Album album3c = new Album("ef","somlth", 10, 10,"www.w3school.com");

        ArrayList<Album> listData= new ArrayList<>();
        listData.add(album1c);
        listData.add(album2c);
        listData.add(album3c);
    return listData;

}
}
