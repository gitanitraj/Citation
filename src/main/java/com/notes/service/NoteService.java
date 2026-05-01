package com.notes;

import java.io.File;

public class NoteService {

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

    public Note readNote(String filename) {
        String filePath = FileUtils.buildNoteFilePath(filename);

        String content = FileUtils.readFile(filePath);

        Note note = NoteParser.parse(content);

        return note;
    }

    public void deleteNote(String filename) {
        // Build file path
        String filePath = FileUtils.buildNoteFilePath(filename);

        File file = new File(filePath);

        // Check if file exists
        if (!file.exists()) {
            System.out.println("Note not found: " + filename);
            return;
        }

        // Attempt delete
        boolean deleted = file.delete();

        if (deleted) {
            System.out.println("Note deleted: " + filename);
        }
    }

    public void searchNotes(String query) {
        String notesPath = FileUtils.getAbsolutePathToNotesHome();
        File folder = new File(notesPath);

        File[] files = folder.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("No notes found.");
            return;
        }

        System.out.println("=== SEARCH RESULTS ===");
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".note")) {
                String content = FileUtils.readFile(file.getAbsolutePath());

                try {
                    Note note = NoteParser.parse(content);

                    //case insensitive search
                    String lowerQuery = query.toLowerCase();

                    if (note.getTitle().toLowerCase().contains(lowerQuery) ||
                        note.getContent().toLowerCase().contains(lowerQuery)) {

                            System.out.println("- " + file.getName());
                    }
                
                } catch (Exception e) {
                    System.out.println("Skipping invalid note: " + file.getName());
                }
            }
        }
    }

}