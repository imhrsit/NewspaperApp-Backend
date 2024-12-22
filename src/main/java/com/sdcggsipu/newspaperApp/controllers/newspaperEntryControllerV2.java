package com.sdcggsipu.newspaperApp.controllers;

import com.sdcggsipu.newspaperApp.entity.newspaperEntry;
import com.sdcggsipu.newspaperApp.services.newspaperEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return null;
    }

    @PostMapping
    public boolean createEntry(@RequestBody newspaperEntry myEntry) {
        newspaperEntryService.saveEntry(myEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public newspaperEntry getEntryById(@PathVariable long myId) {
        return null;
    }

    @DeleteMapping("id/{myId}")
    public newspaperEntry deleteEntryById(@PathVariable long myId) {
        return null;
    }

    @PutMapping("id/{myId}")
    public newspaperEntry updateEntryById(@PathVariable long myId, @RequestBody newspaperEntry myEntry) {
        return null;
    }
}
