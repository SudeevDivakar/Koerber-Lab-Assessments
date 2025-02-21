package com.bookapp.controller;

import com.bookapp.entities.JournalEntry;
import com.bookapp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal-entries")
public class JournalEntryController {

    private JournalEntryService journalEntryService;

    @Autowired
    public JournalEntryController(JournalEntryService journalEntryService) {
        this.journalEntryService = journalEntryService;
    }

    @GetMapping("")
    public ResponseEntity<List<JournalEntry>> getAllJournalEntries() {
        return ResponseEntity.status(HttpStatus.OK).body(journalEntryService.getAllJournalEntries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JournalEntry> getJournalEntry(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(journalEntryService.getJournalEntry(id));
    }

    @PostMapping("/{userId}")
    public ResponseEntity<JournalEntry> saveJournalEntry(@PathVariable String userId, @RequestBody JournalEntry journalEntry) {
        return ResponseEntity.status(HttpStatus.CREATED).body(journalEntryService.saveJournalEntry(userId, journalEntry));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JournalEntry> updateJournalEntry(@PathVariable String id, @RequestBody JournalEntry journalEntry) {
        return ResponseEntity.status(HttpStatus.OK).body(journalEntryService.updateJournalEntry(id, journalEntry));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJournalEntry(@PathVariable String id) {
        journalEntryService.deleteJournalEntry(id);
        return ResponseEntity.status(HttpStatus.OK).body("JournalEntry deleted successfully");
    }
}
