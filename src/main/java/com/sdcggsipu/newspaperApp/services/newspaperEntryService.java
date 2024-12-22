package com.sdcggsipu.newspaperApp.services;

import com.sdcggsipu.newspaperApp.entity.newspaperEntry;
import com.sdcggsipu.newspaperApp.repository.newspaperEntryRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class newspaperEntryService {

    @Autowired
    private newspaperEntryRepo newspaperEntryRepo;

    public void saveEntry(newspaperEntry newspaperEntry) {
        newspaperEntryRepo.save(newspaperEntry);
    }

    public List<newspaperEntry> getAllEntries() {
        return newspaperEntryRepo.findAll();
    }

    public Optional<newspaperEntry> getEntryById(ObjectId id) {
        return newspaperEntryRepo.findById(id);
    }

    public void deleteEntryById(ObjectId id) {
        newspaperEntryRepo.deleteById(id);
    }
}
