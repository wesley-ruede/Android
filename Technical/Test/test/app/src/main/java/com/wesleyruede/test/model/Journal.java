package com.wesleyruede.test.model;

public class Journal {
    private int id;
    private String journalEntry;

    public Journal(int id, String journalEntry) {
        this.id = id;
        this.journalEntry = journalEntry;
    }

    public Journal(String journalEntry) {
        this.journalEntry = journalEntry;
    }

    public Journal() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJournalEntry() {
        return journalEntry;
    }

    public void setJournalEntry(String journalEntry) {
        this.journalEntry = journalEntry;
    }
}
