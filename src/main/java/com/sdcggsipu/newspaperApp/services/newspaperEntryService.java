package com.sdcggsipu.newspaperApp.services;

import com.sdcggsipu.newspaperApp.entity.newspaperEntry;
import com.sdcggsipu.newspaperApp.repository.newspaperEntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class newspaperEntryService {

    @Autowired
    private newspaperEntryRepo newspaperEntryRepo;

    public void saveEntry(newspaperEntry newspaperEntry) {
        newspaperEntryRepo.save(newspaperEntry);

    }
}
