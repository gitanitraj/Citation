package com.notes;

public class Main {
    public static void main(String[] args) {

        NoteService service = new NoteService();

        if (args.length == 0) {
            System.out.println("Usage: notes <command.");
            return;
        }

        String command = args[0];

        switch (command) {
            case "create":
                Note cliNote = new Note("CLI Note", "Created from CLI");
                service.createNote(cliNote, "cli-note.note");
                break;
            
            case "list":
                service.listNotes();
                break;

            case "read":
                if (args.length < 2) {
                    System.out.println("Usage: notes read <filename>");
                    return;
                }
                service.readNote(args[1]);
                break;

            case "delete":
                if (args.length < 2) {
                    System.out.println("Usage: notes delete <filename>");
                    return;
                }
                service.deleteNote(args[1]);
                break;

            case "search":
                if (args.length < 2) {
                    System.out.println("Usage: notes search <query>");
                    return;
                }
                service.searchNotes(args[1]);
                break;

            default:
                System.out.println("Unknown command: " + command);
                break;
        }
    }

}