package com.wesleyruede.cloudstore;

public class Journal {
    private String title;
    private String thought;

    // Need empty constructor fo FireStore
    public Journal() {
    }

    public Journal(String title, String thoughts) {
        this.title = title;
        this.thought = thought;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThought() {
        return thought;
    }

    public void setThought(String thoughts) {
        this.thought = thoughts;
    }
}
