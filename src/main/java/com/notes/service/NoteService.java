package com.notes.service;

import com.notes.model.Note;
import com.notes.utils.FileUtils;
import com.notes.utils.NoteFormatter;

public class NoteService {

    private static final String NOTES_FOLDER = "notes";

    public void createNote(Note note, String filename) {
        // Format note into YAML text
    String formatted = NoteFormatter.formatNote(note);

    // Build full file path inside ~/.notes/notes/
    String filePath = FileUtils.buildNoteFilePath(NOTES_FOLDER + "/" + filename);

    // Write file
    FileUtils.writeFile(filePath, formatted);

    System.out.println("Note created at: " + filePath);

    }

}