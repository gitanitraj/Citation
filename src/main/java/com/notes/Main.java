package com.notes;

import com.notes.config.Config;
import com.notes.utils.FileUtils;

public class Main {
    public static void main(String[] args) {

        String dir = Config.ensureNotesDirectoryExists();
        System.out.println("Notes directory: " + dir);

        String absolute = FileUtils.getAbsolutePathToNotesHome();
        System.out.println("Absolute path: " + absolute);

        String filePath = FileUtils.buildNoteFilePath("test.note");
        System.out.println("Full file path: " + filePath);
    }
}