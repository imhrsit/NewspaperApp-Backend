package com.sdcggsipu.newspaperApp.repository;

import com.sdcggsipu.newspaperApp.entity.newspaperEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface newspaperEntryRepo extends MongoRepository<newspaperEntry, ObjectId> {

}
