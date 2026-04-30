package com.notes;

import com.notes.config.Config;
import com.notes.model.Note;
import com.notes.utils.FileUtils;

public class Main {
    public static void main(String[] args) {

        String dir = Config.ensureNotesDirectoryExists();
        System.out.println("Notes directory: " + dir);

        String absolute = FileUtils.getAbsolutePathToNotesHome();
        System.out.println("Absolute path: " + absolute);

        String filePath = FileUtils.buildNoteFilePath("test.note");
        System.out.println("Full file path: " + filePath);

        Note goodNote = new Note("My Title", "This is content");
        
        System.out.println("Valid note test:");
        System.out.println(Note.isValidNote(goodNote));

        Note badNote1 = new Note("", "This content");

        System.out.println("Empty title test:");
        System.out.println(Note.isValidNote(badNote1));

        String longTitle = "A".repeat(201);

        try {
            System.out.println("Long title test:");
            Note.validateTitle(longTitle);

        } catch (IllegalArgumentException e) {
            System.out.println("long title test failed as expected: ");
            System.out.println(e.getMessage());
        }
        
    }

}