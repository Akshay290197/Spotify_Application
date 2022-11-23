package com.niit.Songs.service;

import com.niit.Songs.model.CommonUser;
import com.niit.Songs.model.Songss;
import com.niit.Songs.model.User;

import java.util.List;

public interface SongService {

    User registerUser(CommonUser commonUser);
    User addSongInPlaylist(Songss songss, String userEmail);
    User deleteSongsInPlaylist(String userEmail, String songName) throws Exception;
    List<Songss> getAllSongs(String userEmail) throws Exception;
}
