package com.notes;

public class NoteParser {

    public static Note parse(String fileContent) {

        System.out.println("RAW FILE CONTENT:");
        System.out.println(fileContent);

        String cleaned = fileContent.trim();

        String[] parts = cleaned.split("---");

        if (parts.length < 3) {
            throw new IllegalArgumentException("Invalid note format");
        }

        String header = parts[1].trim();
        String body = parts[2].trim();

        String[] lines = header.split("\n");

        String title = "";
        String author = "";

        for (String line : lines) {
            if (line.startsWith("title:")) {
                title = line.replace("title:", "").trim();
            }
            if (line.startsWith("author:")) {
                author = line.replace("author:", "").trim();
            }
        }
        
        Note note = new Note(title, body);

        return note;
    }
    
}