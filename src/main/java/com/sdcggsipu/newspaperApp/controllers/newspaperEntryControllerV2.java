package com.sdcggsipu.newspaperApp.controllers;

import com.sdcggsipu.newspaperApp.entity.newspaperEntry;
import com.sdcggsipu.newspaperApp.services.newspaperEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/newspaper")
public class newspaperEntryControllerV2 {

    @Autowired
    private newspaperEntryService newspaperEntryService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<newspaperEntry> all = newspaperEntryService.getAllEntries();
        if (all.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(all, HttpStatus.OK); 
        }
    }

    @PostMapping
    public ResponseEntity<newspaperEntry> createEntry(@RequestBody newspaperEntry myEntry) {
        try {
            myEntry.setDate(LocalDateTime.now());
            newspaperEntryService.saveEntry(myEntry);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("id/{myId}")
    public ResponseEntity<newspaperEntry> getEntryById(@PathVariable ObjectId myId) {
         Optional<newspaperEntry> entry = newspaperEntryService.getEntryById(myId);
         if (entry.isPresent()) {
             return new ResponseEntity<>(entry.get(), HttpStatus.OK);
         }
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteEntryById(@PathVariable ObjectId myId) {
         newspaperEntryService.deleteEntryById(myId);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("id/{myId}")
    public ResponseEntity<?> updateEntryById(@PathVariable ObjectId myId, @RequestBody newspaperEntry newEntry) {
        newspaperEntry oldEntry = newspaperEntryService.getEntryById(myId).orElse(null);
        if(oldEntry != null) {
            oldEntry.setTitle(newEntry.getTitle() != null ? newEntry.getTitle() : oldEntry.getTitle());
            oldEntry.setContent(newEntry.getContent() != null ? newEntry.getContent() : oldEntry.getContent());
            newspaperEntryService.saveEntry(oldEntry);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
