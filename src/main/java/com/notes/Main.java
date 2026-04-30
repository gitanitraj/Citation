package com.notes;

import com.notes.config.Config;
import com.notes.model.Note;
import com.notes.utils.FileUtils;
import com.notes.utils.NoteFormatter;
import com.notes.utils.NoteParser;

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
       
        String testFilePath = FileUtils.buildNoteFilePath("test.note");

        FileUtils.writeFile(testFilePath, "Hello, this is my first note!");

        System.out.println("File written to: " + testFilePath);

        String fileContent = FileUtils.readFile(testFilePath);

        System.out.println("File contents:");
        System.out.println(fileContent);

        Note note = new Note("Test Note", "This is a formatted note.");

        String formatted = NoteFormatter.formatNote(note);

        System.out.println("Formatted note:");
        System.out.println(formatted);
    
    String savedContent = FileUtils.readFile(filePath);

    Note parsedNote = NoteParser.parse(savedContent);

    System.out.println("Parsed note title:");
    System.out.println(parsedNote.getTitle());

    System.out.println("Parsed note content:");
    System.out.println(parsedNote.getContent());
    }

}