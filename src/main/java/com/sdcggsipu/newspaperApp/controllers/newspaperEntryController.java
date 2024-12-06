package com.sdcggsipu.newspaperApp.controllers;

import com.sdcggsipu.newspaperApp.entity.newspaperEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/newspaper")
public class newspaperEntryController {

    private Map<Long, newspaperEntry> newspaperEntries = new HashMap<>();

    @GetMapping
    public List<newspaperEntry> getAll() {
        return new ArrayList<>(newspaperEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody newspaperEntry myEntry) {
        newspaperEntries.put(myEntry.getId(), myEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public newspaperEntry getEntryById(@PathVariable long myId) {
        return newspaperEntries.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public newspaperEntry deleteEntryById(@PathVariable long myId) {
        return newspaperEntries.remove(myId);
    }

    @PutMapping("id/{myId}")
    public newspaperEntry updateEntryById(@PathVariable long myId, @RequestBody newspaperEntry myEntry) {
        return newspaperEntries.put(myId, myEntry);
    }
}
