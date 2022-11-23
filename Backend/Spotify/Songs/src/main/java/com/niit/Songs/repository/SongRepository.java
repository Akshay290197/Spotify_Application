package com.niit.Songs.repository;

import com.niit.Songs.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends MongoRepository<User, String> {

}
