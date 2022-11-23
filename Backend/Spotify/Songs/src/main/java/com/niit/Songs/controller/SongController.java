package com.niit.Songs.controller;

import com.niit.Songs.model.CommonUser;
import com.niit.Songs.model.Songss;
import com.niit.Songs.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/songs/v2")
public class SongController {

    @Autowired
    SongService songService;

    private ResponseEntity<?> responseEntity;

    //http://localhost:8085/songs/v2/register
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody CommonUser commonUser){
        responseEntity =  new ResponseEntity<>(songService.registerUser(commonUser), HttpStatus.CREATED);
        return responseEntity;
    }

    //http://localhost:8085/songs/v2/add/{userEmail}
    @PostMapping("/add/{userEmail}")
    public ResponseEntity<?> addSongInPlaylist(@RequestBody Songss songss, @PathVariable String userEmail){
        responseEntity = new ResponseEntity<>(songService.addSongInPlaylist(songss, userEmail), HttpStatus.CREATED);
        return responseEntity;
    }

    //http://localhost:8085/songs/v2/delete/{userEmail}/{songName}
    @DeleteMapping("/delete/{userEmail}/{songName}")
    public ResponseEntity<?> deleteSongsInPlaylist(@PathVariable String userEmail,@PathVariable String songName) throws Exception {
        responseEntity = new ResponseEntity<>(songService.deleteSongsInPlaylist(userEmail, songName), HttpStatus.OK);
        return responseEntity;
    }

    //http://localhost:8085/songs/v2/get/{userEmail}
    @GetMapping("/get/{userEmail}")
    public ResponseEntity<?> getAllSongs(@PathVariable String userEmail) throws Exception {
        responseEntity = new ResponseEntity<>(songService.getAllSongs(userEmail), HttpStatus.OK);
        return responseEntity;
    }
}
