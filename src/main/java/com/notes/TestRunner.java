package com.notes;

public class TestRunner {

    public static void main(String[] args) {

        Note note = new Note("Test", "Hello world");

        System.out.println(Note.isValidNote(note));

        String formatted = NoteFormatter.formatNote(note);
        System.out.println(formatted);

        Note parsed = NoteParser.parse(formatted);
        System.out.println(parsed.getTitle());
    }
}