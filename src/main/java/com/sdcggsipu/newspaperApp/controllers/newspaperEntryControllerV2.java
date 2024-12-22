package com.sdcggsipu.newspaperApp.controllers;

import com.sdcggsipu.newspaperApp.entity.newspaperEntry;
import com.sdcggsipu.newspaperApp.services.newspaperEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/newspaper")
public class newspaperEntryControllerV2 {

    @Autowired
    private newspaperEntryService newspaperEntryService;

    @GetMapping
    public List<newspaperEntry> getAll() {
        return newspaperEntryService.getAllEntries();
    }

    @PostMapping
    public newspaperEntry createEntry(@RequestBody newspaperEntry myEntry) {
        myEntry.setDate(LocalDateTime.now());
        newspaperEntryService.saveEntry(myEntry);
        return myEntry;
    }

    @GetMapping("id/{myId}")
    public newspaperEntry getEntryById(@PathVariable ObjectId myId) {
        return newspaperEntryService.getEntryById(myId).orElse(null);
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteEntryById(@PathVariable ObjectId myId) {
         newspaperEntryService.deleteEntryById(myId);
         return true;
    }

    @PutMapping("id/{myId}")
    public newspaperEntry updateEntryById(@PathVariable ObjectId myId, @RequestBody newspaperEntry newEntry) {
        newspaperEntry oldEntry = newspaperEntryService.getEntryById(myId).orElse(null);
        if(oldEntry != null) {
            oldEntry.setTitle(newEntry.getTitle() != null ? newEntry.getTitle() : oldEntry.getTitle());
            oldEntry.setContent(newEntry.getContent() != null ? newEntry.getContent() : oldEntry.getContent());
        }
        newspaperEntryService.saveEntry(oldEntry);
        return oldEntry;
    }
}
