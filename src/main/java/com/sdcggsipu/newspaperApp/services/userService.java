package com.sdcggsipu.newspaperApp.services;

import com.sdcggsipu.newspaperApp.entity.newspaperEntry;
import com.sdcggsipu.newspaperApp.entity.user;
import com.sdcggsipu.newspaperApp.repository.newspaperEntryRepo;
import com.sdcggsipu.newspaperApp.repository.userRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class userService {

    @Autowired
    private userRepo userRepository;

    public void saveEntry(user user) {
        userRepository.save(user);
    }

    public List<user> getAll() {
        return userRepository.findAll();
    }

    public Optional<user> getEntryById(ObjectId id) {
        return userRepository.findById(id);
    }

    public void deleteEntryById(ObjectId id) {
        userRepository.deleteById(id);
    }

    public user findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
