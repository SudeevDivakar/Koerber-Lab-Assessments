package com.bookapp.service;

import com.bookapp.entities.JournalEntry;

import java.util.List;

public interface JournalEntryService {
    public List<JournalEntry> getAllJournalEntries();
    public JournalEntry getJournalEntry(String id);
    public JournalEntry saveJournalEntry(String userId, JournalEntry journalEntry);
    public void deleteJournalEntry(String id);
    public JournalEntry updateJournalEntry(String id, JournalEntry journalEntry);
}
