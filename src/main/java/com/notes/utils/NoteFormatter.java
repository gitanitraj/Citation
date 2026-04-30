package com.notes.utils;

import com.notes.model.Note;

public class NoteFormatter {
    public static String formatNote(Note note) {
        StringBuilder sb = new StringBuilder();

        sb.append("---\n");
        sb.append("title: ").append(note.getTitle()).append("\n");
        sb.append("author: ").append(note.getAuthor()).append("\n");
        sb.append("created: ").append(note.getCreatedTimestamp()).append("\n");
        sb.append("modified: ").append(note.getModifiedTimestamp()).append("\n");
        sb.append("tags: ").append(note.getTags()).append("\n");
        sb.append("---\n\n");

        sb.append(note.getContent());

        return sb.toString();
    }

}
