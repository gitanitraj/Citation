package com.notes.service;

import com.notes.model.Note;
import com.notes.utils.FileUtils;
import com.notes.utils.NoteFormatter;
import java.io.File;

public class NoteService {

    private static final String NOTES_FOLDER = "notes";

    public void createNote(Note note, String filename) {
        // Format note into YAML text
    String formatted = NoteFormatter.formatNote(note);

    // Build full file path inside ~/.notes/notes/
    String filePath = FileUtils.buildNoteFilePath(filename);

    // Write file
    FileUtils.writeFile(filePath, formatted);

    System.out.println("Note created at: " + filePath);

    }

    public void listNotes() {

    String notesPath = FileUtils.getAbsolutePathToNotesHome();

    File folder = new File(notesPath);

    File[] files = folder.listFiles();

    if (files == null || files.length == 0) {
        System.out.println("No notes found.");
        return;
    }

    System.out.println("=== NOTES ===");

    for (File file : files) {
        if (file.isFile() && file.getName().endsWith(".note")) {
        System.out.println(file.getName());
        }
    }
    
    }

}