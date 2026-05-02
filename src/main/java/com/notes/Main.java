package com.notes;

import java.util.Scanner;

private static final String CMD_HELP = "--help";
private static final String CMD_CREATE = "create";
private static final String CMD_LIST = "list";
private static final String CMD_READ = "read";
private static final String CMD_EDIT = "edit";
private static final String CMD_DELETE = "delete";
private static final String CMD_SEARCH = "search";
private static final String CMD_STATS = "stats";

public class Main {
    public static void main(String[] args) {
        
        NoteService service = new NoteService();

        if (args.length == 0) {
            printUsage();
            return;
        }

    handleCommand(args, service);
    }
    
    private static void handleCommand(String[] args, NoteService service) {
    String command = args[0];

    switch (command) {
        case CMD_HELP -> showHelp();
        case CMD_CREATE -> handleCreate(service);
        case CMD_LIST -> handleList(args, service);
        case CMD_READ -> handleRead(args, service);
        case CMD_EDIT -> handleEdit(args, service);
        case CMD_DELETE -> handleDelete(args, service);
        case CMD_SEARCH -> handleSearch(args, service);
        case CMD_STATS -> service.showStats();
        default -> printUnknownCommand(command);
    }
    }

    private static void printUsage() {
    System.out.println("Usage: notes <command>");
    }

    private static void showHelp() {
    System.out.println("""
        Notes CLI

        Commands:
          notes --help
          notes create
          notes list
          notes list --tag <tag>
          notes read <id>
          notes edit <id>
          notes delete <id>
          notes search <query>
          notes stats
    """);
    }

    private static void handleRead(String[] args, NoteService service) {
        if (args.length < 2) {
        System.out.println("Usage: notes read <note-id>");
        return;
        }

        service.readNote(args[1]);
    }

    private static void handleList(String[] args, NoteService service) {
        if (args.length == 3 && args[1].equals("--tag")) {
        service.listNotesByTag(args[2]);
        } else {
        service.listNotes();
        }
    }

    private static void handleList(String[] args, NoteService service) {
        if (args.length == 3 && args[1].equals("--tag")) {
        service.listNotesByTag(args[2]);
        } else {
        service.listNotes();
        }
    }

    private static void handleDelete(String[] args, NoteService service) {
    if (args.length < 2) {
        System.out.println("Usage: notes delete <note-id>");
        return;
    }

    String id = args[1];

    if (!confirmDeletion(id)) {
        System.out.println("Deletion cancelled.");
        return;
    }

    service.deleteNote(id);
    }

    private static boolean confirmDeletion(String id) {
    System.out.print("Delete note '" + id + "'? (y/n): ");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    return input.equalsIgnoreCase("y");
    }

    private static void handleSearch(String[] args, NoteService service) {
    if (args.length < 2) {
        System.out.println("Usage: notes search <query>");
        return;
    }

    service.searchNotes(args[1]);
    }

    private static void handleEdit(String[] args, NoteService service) {
    if (args.length < 2) {
        System.out.println("Usage: notes edit <note-id>");
        return;
    }

    service.editNote(args[1]);
    }

    private static void handleCreate(NoteService service) {
    service.createEmptyNote();
    }

}    




        

