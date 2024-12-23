package com.sdcggsipu.newspaperApp.repository;

import com.sdcggsipu.newspaperApp.entity.user;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface userRepo extends MongoRepository<user, ObjectId> {
    user findByUsername(String username);
}
