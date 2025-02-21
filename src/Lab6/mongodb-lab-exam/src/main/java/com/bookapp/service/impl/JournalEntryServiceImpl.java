package com.bookapp.service.impl;

import com.bookapp.entities.JournalEntry;
import com.bookapp.entities.User;
import com.bookapp.exceptions.ResourceNotFoundException;
import com.bookapp.repo.JournalEntryRepo;
import com.bookapp.repo.UserRepo;
import com.bookapp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalEntryServiceImpl implements JournalEntryService {

    private final JournalEntryRepo journalEntryRepo;
    private final UserRepo userRepo;

    @Autowired
    public JournalEntryServiceImpl(JournalEntryRepo journalEntryRepo, UserRepo userRepo) {
        this.journalEntryRepo = journalEntryRepo;
        this.userRepo = userRepo;
    }

    @Override
    public List<JournalEntry> getAllJournalEntries() {
        return journalEntryRepo.findAll();
    }

    @Override
    public JournalEntry getJournalEntry(String id) {
        return journalEntryRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("JournalEntry not found in database"));
    }

    @Override
    public JournalEntry saveJournalEntry(String userId, JournalEntry journalEntry) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found in database"));
        journalEntry = journalEntryRepo.save(journalEntry);

        user.getJournalEntries().add(journalEntry);
        userRepo.save(user);

        return journalEntry;
    }

    @Override
    public void deleteJournalEntry(String id) {
        JournalEntry journalEntry = getJournalEntry(id);
        journalEntryRepo.delete(journalEntry);
    }

    @Override
    public JournalEntry updateJournalEntry(String id, JournalEntry journalEntry) {
        JournalEntry existingJournalEntry = getJournalEntry(id);
        existingJournalEntry.setId(id);
        return journalEntryRepo.save(existingJournalEntry);
    }
}
