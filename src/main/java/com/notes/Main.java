package com.notes;

import com.notes.config.Config;

public class Main {
    public static void main(String[] args) {

        String path = Config.ensureNotesDirectoryExists();
        System.out.println("Notes directory: " + path);
    }
}