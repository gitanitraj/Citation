package com.notes.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Note {

    private String title;
    private String content;
    private LocalDateTime createdTimestamp;
    private LocalDateTime modifiedTimestamp;
    private List<String> tags;

    private String author;   // optional
    private String status;   // optional
    private Integer priority; // optional (1–5)

    public Note(String title, String content) {
        this.title = title;
        this.content = content;

        this.createdTimestamp = LocalDateTime.now();
        this.modifiedTimestamp = LocalDateTime.now();

        this.tags = new ArrayList<>();

        this.author = null;
        this.status = null;
        this.priority = null;
    }

    public static boolean validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }

        if (title.length() > 200) {
            throw new IllegalArgumentException("Title too long (max 200 characters)");
        }
        return true;
    }

    public static boolean isValidNote(Note note) {
        if (note == null) {
            return false;
        }
        if (note.title == null || note.title.trim().isEmpty()) {
            return false;
        }
        if (note.content == null) {
            return false;
        }

        return true;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public LocalDateTime getModifiedTimestamp() {
        return modifiedTimestamp;
    }

    public List<String> getTags() {
        return tags;
    }
}