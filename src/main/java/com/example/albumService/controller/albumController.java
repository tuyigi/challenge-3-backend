package com.example.albumService.controller;


import com.example.albumService.dto.album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/album")
public class albumController {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${album.url}")
    private String albumUrl;
    @GetMapping("/get/{id}")
    public List<album> getAlbum(@PathVariable("id") Long id){

        // call external api
        ResponseEntity<album[]> responseEntity = restTemplate.getForEntity(albumUrl+id+"/photos", album[].class);
        album[] albums =responseEntity.getBody();

        return Arrays.asList(albums);
    }
}
