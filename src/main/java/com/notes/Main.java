package com.notes;

public class Main {
    public static void main(String[] args) {
    
        if (args.length == 0) {
        System.out.println("Usage: notes <command>");
        return;
    }

    String command = args[0];

    NoteService service = new NoteService();

    switch (command) {
        case "list":
            service.listNotes();
            break;

        case "create":
            Note note = new Note("CLI Note", "Created from CLI");
            service.createNote(note, "cli-note.note");
            break;

        case "read":
            Note n = service.readNote(args[1]);
            System.out.println(n.getTitle());
            System.out.println(n.getContent());
            break;

        case "delete":
            service.deleteNote(args[1]);
            break;

        case "search":
            service.searchNotes(args[1]);
            break;

        default:
            System.out.println("Unknown command: " + command); 
    }
    }

}