package com.niit.Songs.service;

import com.niit.Songs.model.CommonUser;
import com.niit.Songs.model.Songss;
import com.niit.Songs.model.User;
import com.niit.Songs.model.UserDTO;
import com.niit.Songs.proxy.Proxi;
import com.niit.Songs.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SongServiceImpl implements SongService{

    @Autowired
    SongRepository songRepository;

    @Autowired
    private Proxi proxi;

    @Override
    public User registerUser(CommonUser commonUser) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserEmail(commonUser.getUserEmail());
        userDTO.setUserName(commonUser.getUserName());
        userDTO.setPasswd(commonUser.getPasswd());
        ResponseEntity<?> response =proxi.sendUserObjectToAuthApp(userDTO);
        System.out.println(response);

        User user = new User(commonUser.getUserEmail(), commonUser.getUserName(),commonUser.getPasswd(),new ArrayList<>());
        return songRepository.insert(user);
    }

    @Override
    public User addSongInPlaylist(Songss songss, String userEmail){
        User user = songRepository.findById(userEmail).get();


        if(user.getSongss() == null)
        {
            user.setSongss(Arrays.asList(songss));
        }
        else {

            List<Songss> songssList = user.getSongss();
            songssList.add(songss);
            user.setSongss(songssList);
        }
        return songRepository.save(user);
    }

    @Override
    public User deleteSongsInPlaylist(String userEmail, String songName) throws Exception {
        boolean songIdExists = false;

        if(songRepository.findById(userEmail).isEmpty())
        {
            throw new Exception("User Not Available");
        }

        User user = songRepository.findById(userEmail).get();

        List<Songss> songssList = user.getSongss();

        songIdExists = songssList.removeIf(i->i.getSongName().equals(songName));

        if(!songIdExists)
        {
            throw new Exception("song not available");
        }
        user.setSongss(songssList);
        return songRepository.save(user);
    }

    @Override
    public List<Songss> getAllSongs(String userEmail) throws Exception {
        return songRepository.findById(userEmail).get().getSongss();
    }
}
